/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package software.amazon.qldb.exceptions;

import software.amazon.awssdk.core.exception.SdkException;

/**
 * Exception that contains the context of an error that occurred during a Execute lifecycle.
 *
 * <p><b>Note</b>: this class is for internal use only.</p>
 */
public class ExecuteException extends RuntimeException {
    private final SdkException cause;
    private final boolean retryable;
    private final boolean aborted;
    private final boolean invalidSessionException;
    private final String transactionId;

    public ExecuteException(SdkException cause,
                            boolean isRetryable,
                            boolean isAborted,
                            boolean isInvalidSessionException,
                            String transactionId) {
        this.cause = cause;
        this.retryable = isRetryable;
        this.aborted = isAborted;
        this.invalidSessionException = isInvalidSessionException;
        this.transactionId = transactionId;
    }

    public SdkException getCause() {
        return cause;
    }

    public boolean isRetryable() {
        return retryable;
    }

    public boolean isAborted() {
        return aborted;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public boolean isInvalidSessionException() {
        return invalidSessionException;
    }
}