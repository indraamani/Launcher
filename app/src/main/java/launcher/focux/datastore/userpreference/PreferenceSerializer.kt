package launcher.focux.datastore.userpreference

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


object PreferenceSerializer : Serializer<PreferencesModel> {
    override val defaultValue: PreferencesModel = PreferencesModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override suspend fun readFrom(input: InputStream): PreferencesModel {
        return try {
            Json.decodeFromString(
                deserializer = PreferencesModel.serializer(),
                string = input.readAllBytes().toString()
            )
        } catch (exception : IOException) {
            throw CorruptionException(exception.toString())
        }
    }

    override suspend fun writeTo(
        t: PreferencesModel,
        output: OutputStream
    ) {
        Json.encodeToString(
            serializer = PreferencesModel.serializer(),
            value = t
        ).toByteArray()
    }
}

val Context.preferenceDatastore : DataStore<PreferencesModel> by dataStore(
    fileName = "settings.json",
    serializer = PreferenceSerializer
)