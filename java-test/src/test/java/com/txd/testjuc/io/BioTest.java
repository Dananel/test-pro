package com.txd.testjuc.io;

import com.txd.io.IoTest;
import org.junit.Test;

public class BioTest {

    @Test
    public void testFile() {
        IoTest ioTest = new IoTest();
        ioTest.testFile();
    }

    @Test
    public void testFileFilter() {
        IoTest ioTest = new IoTest();
        ioTest.testFilefilter();
    }

    @Test
    public void testByteStream() {
        IoTest ioTest = new IoTest();
        ioTest.testByteStream();
    }

    @Test
    public void testBufferdStream() {
        IoTest ioTest = new IoTest();
        ioTest.testBufferedInputstream();
    }

    @Test
    public void testFileReader() {
        IoTest ioTest = new IoTest();
        ioTest.testReader();
    }

    @Test
    public void testReader() {
        IoTest ioTest = new IoTest();
        ioTest.testInputStreamReader();
    }
}
