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

package com.pileproject.drivecommand.machine.device.port;

/***
 * An exception thrown when an attempt to create a subclass of
 * {@link com.pileproject.drivecommand.machine.device.DeviceBase}
 * with inappropriate {@link com.pileproject.drivecommand.machine.device.port.DevicePort} type is occurred.
 * <p>
 * Unchecked exception
 */
public class DevicePortTypeMismatchException extends IllegalArgumentException {
    private static final long serialVersionUID = -2018969863883469894L;

    public DevicePortTypeMismatchException() {
        super();
    }

    public DevicePortTypeMismatchException(String detailMessage) {
        super(detailMessage);
    }

    public DevicePortTypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DevicePortTypeMismatchException(Throwable cause) {
        super(cause);
    }
}
