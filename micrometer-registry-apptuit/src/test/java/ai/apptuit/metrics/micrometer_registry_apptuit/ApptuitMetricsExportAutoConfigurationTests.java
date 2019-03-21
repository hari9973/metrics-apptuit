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

import org.junit.Test;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import static org.assertj.core.api.Assertions.assertThat;



public class ApptuitMetricsExportAutoConfigurationTests {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(
                    AutoConfigurations.of(ApptuitMetricsExportAutoConfiguration.class));

    @Test
    public void backsOffWithoutAClock() {
        this.contextRunner.withUserConfiguration(ApptuitMetricsExportAutoConfiguration.class)
                .run((context) -> assertThat(context)
                        .doesNotHaveBean(ApptuitMeterRegistry.class));
    }

    @Test
    public void autoConfigurationCanBeDisabled() {
        this.contextRunner.withUserConfiguration(ApptuitMetricsExportAutoConfiguration.class)
                .withPropertyValues("management.metrics.export.elastic.enabled=false")
                .run((context) -> assertThat(context)
                        .doesNotHaveBean(ApptuitMeterRegistry.class)
                        .doesNotHaveBean(ApptuitConfig.class));
    }

}