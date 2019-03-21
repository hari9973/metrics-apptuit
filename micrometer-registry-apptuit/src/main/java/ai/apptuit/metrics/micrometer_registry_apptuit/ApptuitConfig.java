/*
 * Copyright 2017 Agilx, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.apptuit.metrics.micrometer_registry_apptuit;

import io.micrometer.core.instrument.step.StepRegistryConfig;


public interface ApptuitConfig extends StepRegistryConfig {

    ApptuitConfig DEFAULT = k -> null;

    String get(String key);

    default String prefix() {
        return "apptuit";
    }
    
    default String token() {
        String v = get(prefix() + ".token");
        return v == null ? "" : v;
    }
}
