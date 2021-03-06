/*
 * Copyright (C) 2011-2015 PILE Project, Inc. <dev@pileproject.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.pileproject.drivecommand.model.pile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class PilePacketFormatter {
    private ByteArrayOutputStream mByteStream;
    private boolean mIsValid;
    private boolean mIsFixed;

    public PilePacketFormatter(PileConstants.CommandTypes type) {
        mByteStream = new ByteArrayOutputStream();
        mByteStream.write(type.value());
        mIsValid = false;
        mIsFixed = false;
    }

    public PilePacketFormatter(byte[] byteArray) {
        mByteStream = new ByteArrayOutputStream();
        try {
            byte checksum = 0x00;
            for (int i = 0; i < byteArray.length - 1; i++)
                checksum ^= byteArray[i];
            if (checksum != byteArray[byteArray.length - 1])
                throw new IOException("Invalid Checksum");
            mByteStream.write(byteArray);
            mIsValid = true;
        } catch (IOException e) {
            e.printStackTrace();
            mByteStream = new ByteArrayOutputStream();
            mIsValid = false;
        }
        mIsFixed = true;
    }

    public void setDataByte(byte dataByte) {
        if (mIsFixed)
            return;
        mByteStream.write((int) dataByte);
    }

    public void calculateChecksum() {
        if (mIsFixed)
            return;
        byte[] dataArray = mByteStream.toByteArray();
        int size = mByteStream.size() + 2; // (+2 means checksum)
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(size);
        byte checksum = (byte) (size & 0xFF);
        // Length
        byteStream.write(size);
        // Type, Data
        for (byte b : dataArray) {
            checksum ^= b;
            byteStream.write(b);
        }
        // Checksum
        byteStream.write(checksum);
        // Swap
        mByteStream = byteStream;
        mIsValid = true;
        mIsFixed = true;
    }

    public byte[] byteArray() {
        if (!mIsValid)
            return null;
        return mByteStream.toByteArray();
    }

    public byte[] data() {
        if (!mIsValid)
            return null;
        byte[] src = mByteStream.toByteArray();
        byte[] dst = new byte[src.length - 3];
        System.arraycopy(src, 2, dst, 0, src.length - 3);
        return dst;
    }

    public boolean isValid() {
        return mIsValid;
    }

    public boolean isFixed() {
        return mIsFixed;
    }
}
