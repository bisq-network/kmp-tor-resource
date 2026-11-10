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
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import resource.validation.extensions.internal.SourceSetName.Companion.toSourceSetName
import resource.validation.extensions.internal.ValidationHash
import java.io.File
import javax.inject.Inject

/**
 * Resource validation and configuration for module `:library:resource-lib-tor`
 *
 * @see [GPL]
 * */
open class LibTorResourceValidationExtension private constructor(
    project: Project,
    isGpl: Boolean,
): AbstractResourceValidationExtension(
    project = project,
    moduleName = "resource-lib-tor" + if (isGpl) "-gpl" else "",
    packageName = "io.matthewnelson.kmp.tor.resource.lib.tor",
) {

    @Inject
    @Suppress("unused")
    internal constructor(project: Project): this(project, isGpl = false)

    protected open val jvmLinuxAndroidAarch64: String = "e77b0b6fa043b004dc7222db60af35e0f18cee59f7384a358646ffbc55ccf058"
    protected open val jvmLinuxAndroidArmv7: String = "1eba09623acd0bc40b34544abac3accb775c921002273b86c8c091d08446d784"
    protected open val jvmLinuxAndroidX86: String = "a26cc91b0d2bc0ec338bc186996e3edf212cbd91086dd42e09e168f865ce81e5"
    protected open val jvmLinuxAndroidX86_64: String = "8d2a6567077af5ebc915bfd2e601ffbb599e3b3d46dc133b6802823936c5a052"

    protected open val jvmLinuxLibcAarch64: String = "9283036b50296ea580fe4ddb3a713a3b39c31022e598d86651a09f145efd240b"
    protected open val jvmLinuxLibcArmv7: String = "aee07b58812245c492eba6b33a0c3343611e90c784e5626e62932074146d96b4"
    protected open val jvmLinuxLibcPpc64: String = "55f8e97e26272b50bb844e4366b877e2141e0ba7daea1647ee6c28dd0c4c2c56"
    protected open val jvmLinuxLibcRiscv64: String = "48a77b5eea274c907b8a2e867b85238d4ae700b0464388c16068be9f6fafdbf5"
    protected open val jvmLinuxLibcX86: String = "c90d77093d760c7e65c567eeecdf2ed590daedefd7a709581efaf500b2629229"
    protected open val jvmLinuxLibcX86_64: String = "e10c0dd6f0ad777c29b357afb83548303a41561a08e59eb6e74d4b8171a9aeb7"

    protected open val jvmLinuxMuslAarch64: String = "fb2d13f1a4f597e440571c6c055edfc8b31abbd9b9b9046b109d8a374939eff7"
    protected open val jvmLinuxMuslX86: String = "56afa393e0bc74c998ed4dedbca8cd31fb6ad57244535ad9b48e2cf5a62fe744"
    protected open val jvmLinuxMuslX86_64: String = "39939dcd280b00b465c3992edae77d60300afb4244452d909cae46e919ffd827"

    protected open val jvmMacosAarch64: String = "b5359bf38f8569caab86dbb91ab8f5c158a0416b99d99acc8fe7c535e98ee483"
    protected open val jvmMacosX86_64: String = "7a2a7b3d895614019211afa2cbf368e79bda530a4cdff25776e56c2f64e83572"

    protected open val jvmMingwX86: String = "136386367f4f1edee32c402c9c6b156d817807482c6d9817a450edaeb261376d"
    protected open val jvmMingwX86_64: String = "e20ff948187a4d702410bb3bedc595ab345351ebba2c7e62fc1ac2e71f9900de"

    private val nativeLinuxArm64: String by lazy { jvmLinuxLibcAarch64 }
    private val nativeLinuxX64: String by lazy { jvmLinuxLibcX86_64 }

    protected open val nativeIosSimulatorArm64: String = "8ba7f1a762713911e674a005da9480d58a115e437ffac99a2900d619cef3cdb6"
    protected open val nativeIosX64: String = "19b05574d9a31fe9b5a30adea1776bf0bfb739cd5b6ddb7f42877e2692039a60"

    protected open val nativeMacosArm64: String = "583a53e5ab0a688a32e73e01e8ed2d4090da49bce274109d1b5d5f1a2bac9d5d"
    protected open val nativeMacosX64: String = "9d4b1957e6a385236db62298624c17fc272531b7edf0b67c544031a3528fdaeb"

    private val nativeMingwX64: String by lazy { jvmMingwX86_64 }

    /**
     * Resource validation and configuration for module `:library:resource-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): LibTorResourceValidationExtension(project, isGpl = true) {

        override val jvmLinuxAndroidAarch64: String = "b9b64f1f29e8672a2eafeb282bf555752f946b8b6cbc0ac87f2d2193c80a3831"
        override val jvmLinuxAndroidArmv7: String = "66728ca6d711327ae6179f80b7e8d5efa5741b65ea7a1b98e11a6ac37603b1a7"
        override val jvmLinuxAndroidX86: String = "11cf6de0812ac77f1d833927414579beb9cdf7d63a4e0c0464cc53ef969af3e7"
        override val jvmLinuxAndroidX86_64: String = "29aae95e8e0b68d9f9388cd4b8448cdf8f885e2f321956711b53b492dd139e94"

        override val jvmLinuxLibcAarch64: String = "0076e480524e0176ee033650ead060ba895f8ef0d713d24e471214f07189682e"
        override val jvmLinuxLibcArmv7: String = "c3150bcf5c5b82beb7061aa04d515876a79115a6f3bca82242fff54896d80f85"
        override val jvmLinuxLibcPpc64: String = "4d0aefdadf84cfbaa9fc310e818da449edc7efd7d866f20dfabc72a569d57aba"
        override val jvmLinuxLibcRiscv64: String = "0eeed0a3e698900c056c14e685783dab08572299d7412950bf06a0f77c4edd79"
        override val jvmLinuxLibcX86: String = "036a8f9739bd6a82a741fb85caec287b223988c38331540e1e46d26c39422c41"
        override val jvmLinuxLibcX86_64: String = "8c6dbfa5db26b99ee42510e8af33fe3f88cc258ca18dd6fa67637594fe6b4c27"

        override val jvmLinuxMuslAarch64: String = "cedfc5d68e6b07b91612acb93b57321ebc4849c81486de6217de01481d92472c"
        override val jvmLinuxMuslX86: String = "080a398800a800833c82fb92dce74353f8c16d8b11bd8acdf8497434c749a3ad"
        override val jvmLinuxMuslX86_64: String = "398bd30f40b6b313f83d712f5089e5e58279b26804beb90c1d72c2df2e53a067"

        override val jvmMacosAarch64: String = "bac36938b29ee7730543ef6ffd82ce2e4314ed3db058c6e93fe9e5bb36142ce3"
        override val jvmMacosX86_64: String = "44bd2d4ed03023b90a7ee9b3550198b11dc9f7ed5db6e2a5bf5b92d6da24374f"

        override val jvmMingwX86: String = "96ce43a1127f349f9bd5b47c5a3455b4f793996944318970cbc1ad3c514c24f3"
        override val jvmMingwX86_64: String = "83e1a2f710bd6b8a5c7fc641168d0a0c1e4da748d73cbabe2ce070ed1d30d8ca"

        override val nativeIosSimulatorArm64: String = "99ad953ad49a40775525c0da719afe6226e7ca1a9a5f03f2e39c981bb8cdc892"
        override val nativeIosX64: String = "40b40157ecde44dc1e5b7b92a539512a45f330503eb5a3e87d23fdd35a495118"

        override val nativeMacosArm64: String = "8d5069f3dd95e3179c92e381623d135b16ad2a5b3e70954b16b12f4bbd235377"
        override val nativeMacosX64: String = "aa8e09eeec8493daa61834c4470f878f71fbfaad331fb5e4e5dfa1e550e176ea"

        internal companion object {
            internal const val NAME = "libTorGPLResourceValidation"
        }
    }

    fun jvmNativeLibResourcesSrcDir(): File = jvmNativeLibsResourcesSrcDirProtected()
    fun errorReportJvmNativeLibResources(): String = errorReportJvmNativeLibsProtected()
    fun configureNativeResources(kmp: KotlinMultiplatformExtension) { configureNativeResourcesProtected(kmp) }
    @Throws(IllegalArgumentException::class, IllegalStateException::class)
    fun errorReportNativeResource(sourceSet: String): String = errorReportNativeResourceProtected(sourceSet)

    final override val hashes: Set<ValidationHash> by lazy { setOf(
        // jvm linux-android
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "android",
            arch = "aarch64",
            libName = "libtor.so.gz",
            hash = jvmLinuxAndroidAarch64,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "android",
            arch = "armv7",
            libName = "libtor.so.gz",
            hash = jvmLinuxAndroidArmv7,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "android",
            arch = "x86",
            libName = "libtor.so.gz",
            hash = jvmLinuxAndroidX86,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "android",
            arch = "x86_64",
            libName = "libtor.so.gz",
            hash = jvmLinuxAndroidX86_64,
        ),

        // jvm linux-libc
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "libc",
            arch = "aarch64",
            libName = "libtor.so.gz",
            hash = jvmLinuxLibcAarch64,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "libc",
            arch = "armv7",
            libName = "libtor.so.gz",
            hash = jvmLinuxLibcArmv7,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "libc",
            arch = "ppc64",
            libName = "libtor.so.gz",
            hash = jvmLinuxLibcPpc64,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "libc",
            arch = "riscv64",
            libName = "libtor.so.gz",
            hash = jvmLinuxLibcRiscv64,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "libc",
            arch = "x86",
            libName = "libtor.so.gz",
            hash = jvmLinuxLibcX86,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "libc",
            arch = "x86_64",
            libName = "libtor.so.gz",
            hash = jvmLinuxLibcX86_64,
        ),

        // jvm linux-musl
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "musl",
            arch = "aarch64",
            libName = "libtor.so.gz",
            hash = jvmLinuxMuslAarch64,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "musl",
            arch = "x86",
            libName = "libtor.so.gz",
            hash = jvmLinuxMuslX86,
        ),
        ValidationHash.LibJvm(
            osName = "linux",
            osSubtype = "musl",
            arch = "x86_64",
            libName = "libtor.so.gz",
            hash = jvmLinuxMuslX86_64,
        ),

        // jvm macos
        ValidationHash.LibJvm(
            osName = "macos",
            arch = "aarch64",
            libName = "libtor.dylib.gz",
            hash = jvmMacosAarch64,
        ),
        ValidationHash.LibJvm(
            osName = "macos",
            arch = "x86_64",
            libName = "libtor.dylib.gz",
            hash = jvmMacosX86_64,
        ),

        // jvm mingw
        ValidationHash.LibJvm(
            osName = "mingw",
            arch = "x86",
            libName = "tor.dll.gz",
            hash = jvmMingwX86,
        ),
        ValidationHash.LibJvm(
            osName = "mingw",
            arch = "x86_64",
            libName = "tor.dll.gz",
            hash = jvmMingwX86_64,
        ),

        // native linux
        ValidationHash.ResourceNative(
            sourceSetName = "linuxArm64".toSourceSetName(),
            ktFileName = "resource_libtor_so_gz.kt",
            hash = nativeLinuxArm64,
        ),
        ValidationHash.ResourceNative(
            sourceSetName = "linuxX64".toSourceSetName(),
            ktFileName = "resource_libtor_so_gz.kt",
            hash = nativeLinuxX64,
        ),

        // native ios-simulator
        ValidationHash.ResourceNative(
            sourceSetName = "iosSimulatorArm64".toSourceSetName(),
            ktFileName = "resource_libtor_dylib_gz.kt",
            hash = nativeIosSimulatorArm64,
        ),
        ValidationHash.ResourceNative(
            sourceSetName = "iosX64".toSourceSetName(),
            ktFileName = "resource_libtor_dylib_gz.kt",
            hash = nativeIosX64,
        ),

        // native macos
        ValidationHash.ResourceNative(
            sourceSetName = "macosArm64".toSourceSetName(),
            ktFileName = "resource_libtor_dylib_gz.kt",
            hash = nativeMacosArm64,
        ),
        ValidationHash.ResourceNative(
            sourceSetName = "macosX64".toSourceSetName(),
            ktFileName = "resource_libtor_dylib_gz.kt",
            hash = nativeMacosX64,
        ),

        // native mingw
        ValidationHash.ResourceNative(
            sourceSetName = "mingwX64".toSourceSetName(),
            ktFileName = "resource_tor_dll_gz.kt",
            hash = nativeMingwX64,
        ),
    ) }

    internal companion object {
        internal const val NAME = "libTorResourceValidation"
    }
}
