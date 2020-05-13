package org.totschnig.robolectrictestapplication

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object TestUtils {
    fun read(inputStream: InputStream) = mutableListOf<String>().also { list ->
        inputStream.use { stream ->
            BufferedReader(InputStreamReader(stream)).use { reader ->
                while (reader.readLine()?.also { list.add(it) } != null) {}
            }
        }
    }
}