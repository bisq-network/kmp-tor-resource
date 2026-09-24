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

    protected open val jvmLinuxAndroidAarch64: String = "ac41bbbf715bc1aa3ec4dcf9987ae7f71e28015e526b0a814760342301d02794"
    protected open val jvmLinuxAndroidArmv7: String = "d2def6874042db68516c90338ae2757e24ff7289a987c163581a113c57da6781"
    protected open val jvmLinuxAndroidX86: String = "0d4a7e5f253a36bd7c787d25068ed46c98ae306e2c5a4ed8d2bbba77c2009a27"
    protected open val jvmLinuxAndroidX86_64: String = "c68b45849c2874f48797d7ecf11edd08f22e6705ba94e1f69e4bb069c59575d9"

    protected open val jvmLinuxLibcAarch64: String = "e3fe217959c52fbab4a959681ff4266f150b742b11f17ae86952d9a8f65403ce"
    protected open val jvmLinuxLibcArmv7: String = "0e809af243f5aa593ea2dab1d294988c341c9175844d2a3ec473c89460d182ba"
    protected open val jvmLinuxLibcPpc64: String = "63d4b0b932cfd8cceac0fb9c3856a080d3d45200ebdf3d95e5e44f2c87810f61"
    protected open val jvmLinuxLibcRiscv64: String = "b454cb7423fb31f6c0ea4cded35e4c54ab954120dea9fa4d9d9486fa4e8e784a"
    protected open val jvmLinuxLibcX86: String = "c51ad98e371e3b72bf702a8f85b7f558d4be22d8bfeca48fc63c9718a22d7220"
    protected open val jvmLinuxLibcX86_64: String = "7e42f4a7a866f562ae706f7fc3a59dcc829f98f69227b19ad55ae7e722020725"

    protected open val jvmLinuxMuslAarch64: String = "e3d4967306e1cac48b02795a79d919858c1e1cf36a6db432f271b7fe361f88e9"
    protected open val jvmLinuxMuslX86: String = "503c148df169a1bcbf805c8f8c24b9bcc1d3dc56f6cad619641db845121a6903"
    protected open val jvmLinuxMuslX86_64: String = "806483faa2b519020ac613d07f7b5d04ddf0c7b88015c282ec7adb47df170670"

    protected open val jvmMacosAarch64: String = "4ca3fdbe195c238bfffe553621bd64fd17634fb63115ef9127e62e0529e9dfe6"
    protected open val jvmMacosX86_64: String = "b0f34724f3778ec2df4703b47d43cbfbbb1dd9bf076bd5ef80f17fa5b65157f2"

    protected open val jvmMingwX86: String = "6ffd9d6c9e64593e94a3e7ff354aaa35b0c0cf4b388d5cbfd65c56bddd5d82ed"
    protected open val jvmMingwX86_64: String = "2626597ee9eff5c4dfe629687f29b5ed80b07d71ac44ce7c4cd16d0107fc2c56"

    private val nativeLinuxArm64: String by lazy { jvmLinuxLibcAarch64 }
    private val nativeLinuxX64: String by lazy { jvmLinuxLibcX86_64 }

    protected open val nativeIosSimulatorArm64: String = "ce8eb01e912d897b8588db7146b370d96099df4ce1800f61f136edd096b60647"
    protected open val nativeIosX64: String = "83e593894c7ed7437bb7f62d5315cfe9c2a00bbd81a614fffe23bc0d39bb72ba"

    protected open val nativeMacosArm64: String = "71b2dcaf1c7416177f62ca9f00d5535a9897c2a1d5c689d1ce13951b4c25d8e1"
    protected open val nativeMacosX64: String = "d8c3cc954cadd8858e52bd68e8ee0d20d3a7b9309c54f0c74fdb53ec22d75c14"

    private val nativeMingwX64: String by lazy { jvmMingwX86_64 }

    /**
     * Resource validation and configuration for module `:library:resource-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): LibTorResourceValidationExtension(project, isGpl = true) {

        override val jvmLinuxAndroidAarch64: String = "64bb7f04784cdbb0306ee4c577f04a58a765e5284bc32a9b28e1f721d03b413e"
        override val jvmLinuxAndroidArmv7: String = "1f11311af2f1b18db999cd12b35652b16a59a186c9234b74037daa42cbb2a211"
        override val jvmLinuxAndroidX86: String = "f1ce2062ecfca4c659a4a696ec35c49dfe5137a261623e4c9eab501d0fb78785"
        override val jvmLinuxAndroidX86_64: String = "256ce27afd3435f69bb4f021a4604d6a4b1ff93b1b6422e0d22ce6cd7a1f8e0a"

        override val jvmLinuxLibcAarch64: String = "b9957f64f92cadaacd948e2d83c5bd9c7676b9f8ecba193d28b74f3a0dbbbe81"
        override val jvmLinuxLibcArmv7: String = "4247dfe0d971f661f35efc571d9121a1fed55b8df14c2ffd355b43789e080545"
        override val jvmLinuxLibcPpc64: String = "d816438aec4a35bb0ec828c6d7e5f7344e707e8a6b695dd7cd3fe2e45cfbf0c2"
        override val jvmLinuxLibcRiscv64: String = "f220518d7ca7380dccff1b66b98f89850029e1103aaa0b45d597f2baf5522d14"
        override val jvmLinuxLibcX86: String = "a297f9e034c3c22216e84575a91e5a299f034400dbaae4969245579e5bc82578"
        override val jvmLinuxLibcX86_64: String = "c50a6bdf341a9e44894436c1891451dfe7ff6d94043553a329c7a9cd5744214e"

        override val jvmLinuxMuslAarch64: String = "eba8f0f01f5cf13d80fa47ed690eb7730698d9d1f9c38627f63321cc0d04f74c"
        override val jvmLinuxMuslX86: String = "60beec202d4a4ab070ca91be9ee2ce7dafaa9272c710b53eabc15e0cf2953571"
        override val jvmLinuxMuslX86_64: String = "f46a88da0738ece61f012002a6257c8ad160d769a697734afba1cb72761facbf"

        override val jvmMacosAarch64: String = "3bb2f1b0e02652ecd6bc1b1eecb84d8457581c2f3a3144e61abc25a188a2a7a1"
        override val jvmMacosX86_64: String = "cb2a6f61a0feb86085bd0bbf0b4522cd43ca8011e0f532a91495d708558862cb"

        override val jvmMingwX86: String = "a17a08780c189553d462409184d0ee49abd762b7fe43e9032fb839ab63a903b7"
        override val jvmMingwX86_64: String = "d10d0501dc1312983c3964332c7285ca59c7f4bbe6eb3400d04e47dfd96d71ac"

        override val nativeIosSimulatorArm64: String = "b00ff3fb09ca092705abb286e85ffb5a735086474627387087737de647afbd6a"
        override val nativeIosX64: String = "729902be0518d605b7f3adb13ca92e091d65c8b252a97c9da0a6c6b01e8d284c"

        override val nativeMacosArm64: String = "0431e7d5605d415b59acdc8f02a1ff8e78db4aba959b5cab921858b998fd1516"
        override val nativeMacosX64: String = "10e442959df792713a5321f50565d9f230265ad4b562d695d12dda36f7e03e73"

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
