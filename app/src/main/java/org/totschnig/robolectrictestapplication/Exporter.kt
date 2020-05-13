package org.totschnig.robolectrictestapplication

import android.content.Context
import android.net.Uri
import androidx.documentfile.provider.DocumentFile
import java.io.OutputStreamWriter

object Exporter {
    fun export(context: Context, content: String, append: Boolean): Uri? =
        context.getExternalFilesDir(null)?.let { DocumentFile.fromFile(it)
            .createFile("text/plain", "Debug") }?.uri?.also {
            context.contentResolver.openOutputStream(it, if (append) "wa" else "w")?.use {
                OutputStreamWriter(it).use {
                    it.write(content)
                    it.write("\n")
                }
            }
        }
}