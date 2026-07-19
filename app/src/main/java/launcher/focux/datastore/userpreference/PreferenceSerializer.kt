package launcher.focux.datastore.userpreference

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


object PreferenceSerializer : Serializer<PreferenceModel> {
    override val defaultValue: PreferenceModel = PreferenceModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override suspend fun readFrom(input: InputStream): PreferenceModel {
        return try {
            Json.decodeFromString(
                deserializer = PreferenceModel.serializer(),
                string = input.readAllBytes().toString()
            )
        } catch (exception : IOException) {
            throw CorruptionException(exception.toString())
        }
    }

    override suspend fun writeTo(
        t: PreferenceModel,
        output: OutputStream
    ) {
        Json.encodeToString(
            serializer = PreferenceModel.serializer(),
            value = t
        ).toByteArray()
    }
}

val Context.preferenceDatastore : DataStore<PreferenceModel> by dataStore(
    fileName = "settings.json",
    serializer = PreferenceSerializer
)