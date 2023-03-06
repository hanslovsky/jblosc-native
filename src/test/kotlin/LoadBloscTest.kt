package com.hanslovsky.jblosc.native

import org.blosc.JBlosc
import org.junit.Assert
import org.junit.Test
import org.scijava.nativelib.NativeLibraryUtil
import org.scijava.nativelib.NativeLoader
import java.io.IOException
import java.nio.ByteBuffer

class LoadBloscTest {

    @Test fun loadBlosc() = Assert.assertTrue(loadNativeLibrary("blosc"))
    @Test fun failLoadLibrary(): Unit = Assert.assertFalse(loadNativeLibrary("csolb"))
    @Test fun runBlosc() {
        loadBlosc()
        val blosc = JBlosc()
        blosc.compress(
            0,
            0,
            1,
            ByteBuffer.allocate(1),
            1L,
            ByteBuffer.allocate(1 + JBlosc.OVERHEAD),
            1L + JBlosc.OVERHEAD
        )
    }

    companion object {
        val jniExtractor get() = NativeLoader.getJniExtractor()
        fun loadNativeLibrary(libName: String): Boolean = NativeLibraryUtil.loadNativeLibrary(jniExtractor, libName)
    }
}