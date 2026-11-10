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

    protected open val androidAarch64: String = "b05be712df551492bc2dc6f2713ebc62d03f025f0e6edc2f0ad9a69eea921693"
    protected open val androidArmv7: String = "75b12bb3b08ae0d5415c67d0836ddda14dda9ddcd55eb8850cd72e428c11fa6a"
    protected open val androidX86: String = "645e7d60a57a76e5afc711b4024c58a811f50cebe7bff6955f6259bb623597f4"
    protected open val androidX86_64: String = "f0d68edd4bd5412e04695c40b0a520d96e856a5bfe247c811d951b3f90ae04c8"

    /**
     * Resource validation and configuration for module `:library:resource-compilation-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): CompilationLibTorResourceValidationExtension(project, isGpl = true) {

        override val androidAarch64: String = "ddf1970963ef421250216d3941e17fa83347bbe8b32459099860b7250c707083"
        override val androidArmv7: String = "cbd13ce4b83716f4fa0864bf610f4a95ce1179ef659698c090a60a4e4ea445bf"
        override val androidX86: String = "99bd90fa4908d8ff644cf8c0a043b01e5ab77dce03b25f63630e04bea05539e4"
        override val androidX86_64: String = "fd68b0df6e015ee200259f08f9b09fb49970c85eff7594819b23d48bea336711"

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
