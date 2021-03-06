package org.totschnig.robolectrictestapplication

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.totschnig.robolectrictestapplication.TestUtils.read
import java.io.File
import java.io.FileInputStream

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
	@Test
	fun appendContent() {
		val context = ApplicationProvider.getApplicationContext<Context>()
		val uri = Exporter.export(context, "Line 1", false)!!
		assertEquals(uri, Exporter.export(context, "Line 2", true))
		FileInputStream(File(uri.path!!)).use {
			assertEquals(listOf("Line 1", "Line 2"), read(it))
		}
	}
}
