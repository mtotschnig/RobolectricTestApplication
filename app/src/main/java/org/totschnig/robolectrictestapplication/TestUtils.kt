package org.totschnig.robolectrictestapplication

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object TestUtils {
    fun read(inputStream: InputStream): MutableList<String> {
        val results = mutableListOf<String>()
        inputStream.use { stream ->
            BufferedReader(InputStreamReader(stream)).use { reader ->
                while (reader.readLine()?.also { results.add(it) } != null) {}
            }
        }
        return results
    }
}