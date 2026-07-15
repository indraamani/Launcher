package launcher.focux.datastore.pinnedapp

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

object PinnedAppModelSerializer : Serializer<PinnedAppModel> {
    override val defaultValue: PinnedAppModel = PinnedAppModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override suspend fun readFrom(input: InputStream): PinnedAppModel {
        return try {
            Json.decodeFromString(
                deserializer = PinnedAppModel.serializer(),
                string = input.readAllBytes().decodeToString()
            )
        } catch (exception : SerializationException) {
            throw CorruptionException(exception.toString())
        }
    }

    override suspend fun writeTo(
        t: PinnedAppModel,
        output: OutputStream
    ) {
        output.write(
            Json.encodeToString(
                serializer = PinnedAppModel.serializer(),
                value = t
            ).toByteArray()
        )
    }
}


val Context.pinnedAppModelDatastore: DataStore<PinnedAppModel> by dataStore(
    fileName = "pinned_app.json",
    serializer = PinnedAppModelSerializer
)