package launcher.focux.datastore.app

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object ApplicationSerializer : Serializer<InstalledPackage> {
    override val defaultValue: InstalledPackage = InstalledPackage()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override suspend fun readFrom(input: InputStream): InstalledPackage {
        return try {
            Json.decodeFromString(
                deserializer = InstalledPackage.serializer(),
                string = input.readAllBytes().decodeToString()
            )
        } catch (exception : Exception) {
            throw CorruptionException(exception.toString())
        }
    }

    override suspend fun writeTo(
        t: InstalledPackage,
        output: OutputStream
    ) {
        output.write(
            Json.encodeToString(
                serializer = InstalledPackage.serializer(),
                value = t
            ).toByteArray()
        )
    }
}


val Context.applicationDatastore: DataStore<InstalledPackage> by dataStore(
    fileName = "installed_packages.json",
    serializer = ApplicationSerializer
)