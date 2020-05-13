package org.totschnig.robolectrictestapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.totschnig.robolectrictestapplication.TestUtils.read
import java.io.File
import java.io.FileInputStream

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
	@Test
	fun appendContent() {
		// Context of the app under test.
		val appContext = InstrumentationRegistry.getInstrumentation().targetContext
		val uri = Exporter.export(appContext, "Line 1", false)!!
		assertEquals(uri, Exporter.export(appContext, "Line 2", true))
		FileInputStream(File(uri.path!!)).use {
			assertEquals(listOf("Line 1", "Line 2"), read(it))
		}
	}
}
