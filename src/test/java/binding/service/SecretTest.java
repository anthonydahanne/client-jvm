/*
 * Copyright 2021 the original author or authors.
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
 */

package binding.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Secret")
final class SecretTest {

    @DisplayName("valid")
    @Test
    void valid() {
        String[] valid = new String[]{
            "alpha",
            "BRAVO",
            "Charlie",
            "delta01",
            "echo-foxtrot",
            "golf_hotel",
            "india.juliet",
            ".kilo"
        };

        for (String v : valid) {
            assertThat(Secret.isValidSecretKey(v)).isTrue();
        }
    }

    @DisplayName("invalid")
    @Test
    void invalid() {
        String[] invalid = new String[]{
            "lima^mike"
        };

        for (String i : invalid) {
            assertThat(Secret.isValidSecretKey(i)).isFalse();
        }
    }
}
