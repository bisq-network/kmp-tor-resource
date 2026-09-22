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

    protected open val androidAarch64: String = "2b8521bc4adcc3c0c70b6f429411117f8fdc996a4755d6b2eecc560fed463b34"
    protected open val androidArmv7: String = "b86ea04f1edb5664a87e5dbadc8d4011872199e548bed1cd5ac194e86911fea0"
    protected open val androidX86: String = "8a9b721e9b5fa9be88f0ef614f6c47da04f2f9dd97349144b9482889a79e1f72"
    protected open val androidX86_64: String = "f08e858d7304bd9e7f2fe1d4c50866b4347aefd83784b581619d356d04412a66"

    /**
     * Resource validation and configuration for module `:library:resource-compilation-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): CompilationLibTorResourceValidationExtension(project, isGpl = true) {

        override val androidAarch64: String = "5c5f87272cdb11c3aed85e0a2bfb4a70fe86f2adbfffb63c17bbd3457c2e235d"
        override val androidArmv7: String = "4ccc935aaba14b6a8c76da7a43e34c62ca44066ecc0571e19306247722f38c18"
        override val androidX86: String = "a88f52bb54e38accd4a1db002db654cd21c681e202d486ca9392f51d1214f7fe"
        override val androidX86_64: String = "201594cca10e285469b1f42590a17d49eabd43e0e2f472dca19ce1140df240be"

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
