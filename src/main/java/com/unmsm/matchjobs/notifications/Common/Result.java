package com.unmsm.matchjobs.notifications.Common;

import java.util.function.Consumer;

public abstract class Result<SUCCESS, FAILURE> {
    public Result() {
    }

    public abstract boolean isSuccess();

    public abstract boolean isFailure();

    public abstract SUCCESS getSuccess();

    public abstract FAILURE getFailure();

    public abstract Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> var1);

    public abstract Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> var1);

    public static <SUCCESS, FAILURE> Result<SUCCESS, FAILURE> failure(FAILURE failure) {
        return new Failure(failure);
    }

    public static <SUCCESS, FAILURE> Result<SUCCESS, FAILURE> success(SUCCESS success) {
        return new Success(success);
    }

    public static class Failure<SUCCESS, FAILURE> extends Result<SUCCESS, FAILURE> {
        private final FAILURE _failure;

        private Failure(FAILURE failure) {
            this._failure = failure;
        }

        public boolean isSuccess() {
            return false;
        }

        public boolean isFailure() {
            return true;
        }

        public SUCCESS getSuccess() {
            throw new IllegalStateException("getSuccess called on Failure");
        }

        public FAILURE getFailure() {
            return this._failure;
        }

        public String toString() {
            return "Failure [_failure=" + this._failure + "]";
        }

        public Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess) {
            return this;
        }

        public Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure) {
            consumerFailure.accept(this._failure);
            return this;
        }
    }

    public static class Success<SUCCESS, FAILURE> extends Result<SUCCESS, FAILURE> {
        private final SUCCESS _success;

        private Success(SUCCESS success) {
            this._success = success;
        }

        public boolean isSuccess() {
            return true;
        }

        public boolean isFailure() {
            return false;
        }

        public SUCCESS getSuccess() {
            return this._success;
        }

        public FAILURE getFailure() {
            throw new IllegalStateException("getFailure called on Success");
        }

        public String toString() {
            return "Success [_success=" + this._success + "]";
        }

        public Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess) {
            consumerSuccess.accept(this._success);
            return this;
        }

        public Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure) {
            return this;
        }
    }
}
