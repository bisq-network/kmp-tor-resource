/*
 * Copyright (c) 2024 Matthew Nelson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
@file:Suppress("PropertyName")

package resource.validation.extensions

import org.gradle.api.Project
import resource.validation.extensions.internal.ValidationHash
import javax.inject.Inject

/**
 * Resource validation and configuration for module `:library:resource-compilation-lib-tor`
 *
 * @see [GPL]
 * */
open class CompilationLibTorResourceValidationExtension private constructor(
    project: Project,
    isGpl: Boolean,
): AbstractResourceValidationExtension(
    project = project,
    moduleName = "resource-compilation-lib-tor" + if (isGpl) "-gpl" else "",
    packageName = "io.matthewnelson.kmp.tor.resource.compilation.lib.tor",
) {

    @Inject
    @Suppress("unused")
    internal constructor(project: Project): this(project, isGpl = false)

    protected open val androidAarch64: String = "c4ca5869880b2838c3faf5da9f9f7e3f9acbcfeb2c33a0c5b70e3489cfe12d3f"
    protected open val androidArmv7: String = "3f20a7f974df52230b14841fe6fd8b16224e168f15111a7f35d24f0e39539add"
    protected open val androidX86: String = "3cc23aa52ff63bdbafb37952aa90901881a7d76a61ab77457fc5c9b8871e7737"
    protected open val androidX86_64: String = "a853357ca75fc07a053b8d2ddaad747f6eb48560daf2c605c676e28744bb12ea"

    /**
     * Resource validation and configuration for module `:library:resource-compilation-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): CompilationLibTorResourceValidationExtension(project, isGpl = true) {

        override val androidAarch64: String = "17de2f2fb7d82460553845e1f1f67f94db89071531eb1cf126818ad19471f12b"
        override val androidArmv7: String = "244aacb00f5f751c42fcff56a0970036e38ca3e560528aacb452bae2cf08a7d7"
        override val androidX86: String = "252df6232124edebdb4511cd2f219bda7f4954ff9cdab28c368b4cfb70d89156"
        override val androidX86_64: String = "7327facc20709f945d5c869a96a017bfd7afa32df4a2e602ffd3af0d2855b054"

        internal companion object {
            internal const val NAME = "compilationLibTorGPLResourceValidation"
        }
    }

    fun configureAndroidJniResources() { configureLibAndroidProtected() }
    fun errorReportAndroidJniResources(): String = errorReportLibAndroidProtected()

    final override val hashes: Set<ValidationHash> by lazy { setOf(
        // android
        ValidationHash.LibAndroid(
            libname = "libtor.so",
            hashArm64 = androidAarch64,
            hashArmv7 = androidArmv7,
            hashX86 = androidX86,
            hashX86_64 = androidX86_64,
        ),
    ) }

    internal companion object {
        internal const val NAME = "compilationLibTorResourceValidation"
    }
}
