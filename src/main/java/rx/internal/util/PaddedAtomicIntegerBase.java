/**
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package rx.internal.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The atomic integer base padded at the front.
 * Based on Netty's implementation.
 */
abstract class PaddedAtomicIntegerBase extends FrontPadding {

    private static final long serialVersionUID = 6513142711280243198L;

    private AtomicInteger value = new AtomicInteger(); // 8-byte object field (or 4-byte + padding)

    public final int get() {
        return value.get();
    }

    public final void set(int newValue) {
        this.value.set(newValue);
    }

    public final void lazySet(int newValue) {
        value.lazySet(newValue);
    }

    public final boolean compareAndSet(int expect, int update) {
        return value.compareAndSet(expect, update);
    }

    public final boolean weakCompareAndSet(int expect, int update) {
        return value.weakCompareAndSet(expect, update);
    }

    public final int getAndSet(int newValue) {
        return value.getAndSet(newValue);
    }

    public final int getAndAdd(int delta) {
        return value.getAndAdd(delta);
    }
    public final int incrementAndGet() {
        return value.incrementAndGet();
    }
    public final int decrementAndGet() {
        return value.decrementAndGet();
    }
    public final int getAndIncrement() {
        return value.getAndIncrement();
    }
    public final int getAndDecrement() {
        return value.getAndDecrement();
    }
    public final int addAndGet(int delta) {
        return value.addAndGet(delta);
    }
    
    @Override
    public String toString() {
        return String.valueOf(get());
    }
}