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

    protected open val jvmLinuxAndroidAarch64: String = "e8cfae0ebc608b4800e9cbdd50e72d489b0be4344eb4b53325dae7e251805ef0"
    protected open val jvmLinuxAndroidArmv7: String = "5262306498b5ac5263d94a503903ef166533f3b1337f81dfe7be7778dd587cf3"
    protected open val jvmLinuxAndroidX86: String = "a45621f881e7f75725b1725b390563101736caaa1a83112dfd119144fffd7822"
    protected open val jvmLinuxAndroidX86_64: String = "9cdab7ca2fd338a0cd01db2241c218e0cae6ce70f74477d1dd8c5b831881a2b2"

    protected open val jvmLinuxLibcAarch64: String = "8cde63a4f6a365287a887b8e5c0b88f66db1b5cd3d278bd39a84abbabc44a1e4"
    protected open val jvmLinuxLibcArmv7: String = "1fe95e071d8bbc4a7324950779ef83e5dbdca9088cb0373f7ee0dafef131a31c"
    protected open val jvmLinuxLibcPpc64: String = "f62d6434e8ee78817026e407fe0e2df0e49f737ff6b8fad776bc35ecbe200ad4"
    protected open val jvmLinuxLibcRiscv64: String = "5580f28b1fa1e8121b21979c510c1f2fbb03bb31f05f669174777a45ca05dbc0"
    protected open val jvmLinuxLibcX86: String = "ffe8f923110cee2f3cca69d3e1201b8eab07f0041cb639c74048c45b7231f227"
    protected open val jvmLinuxLibcX86_64: String = "38989c20e2bc2b7223976b15ca1b9d2bbb13235337e356db2d7b4e2e8a455530"

    protected open val jvmLinuxMuslAarch64: String = "7cc49b00a7009da74cbc1ad634ce94d99b8427a5ee64c146e18d57e45d5b4ba6"
    protected open val jvmLinuxMuslX86: String = "491a751ab2edb7e400bd5a0adb7368b755e809a7e46ea284b28e5787baf4442d"
    protected open val jvmLinuxMuslX86_64: String = "febdf6eea1289c65081b72df4b962b5e928258e720c375e2f97f5b48b5f8fbb3"

    protected open val jvmMacosAarch64: String = "e4c6960ea7d31eb8574246976c9736b6e13ca049c90a29f3cdce7413f14d18f5"
    protected open val jvmMacosX86_64: String = "b9e548a929aeb769e273bc202fe2363b99ea1249cce8ee35f784c650e2492a7f"

    protected open val jvmMingwX86: String = "59e955cbcf3e4b8ab35ee9b6491678affc6fcb10a65adf66317cf16ce9ed4f94"
    protected open val jvmMingwX86_64: String = "67f739f73f0693a837c4c6b73d2430ea5fb006d25b7d97d1d1d5d54df65430bb"

    private val nativeLinuxArm64: String by lazy { jvmLinuxLibcAarch64 }
    private val nativeLinuxX64: String by lazy { jvmLinuxLibcX86_64 }

    protected open val nativeIosSimulatorArm64: String = "b7ac0af7426f9dfb94fb26f42bbbf0f06fd5fdc804ea4c350163217012480cf9"
    protected open val nativeIosX64: String = "20d84a41a787ab35bd8e12e679f9da4222cd7f037ccb10aa24a4b762431a9940"

    protected open val nativeMacosArm64: String = "4af61ccd592153db5f63de7f7adae8b69f10ded346e019ad352d4b3a4a35f02a"
    protected open val nativeMacosX64: String = "8e06d28b313e713a951575aaa341e6c74d07c86fbeb4bc2828372a51c3cae4e5"

    private val nativeMingwX64: String by lazy { jvmMingwX86_64 }

    /**
     * Resource validation and configuration for module `:library:resource-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): LibTorResourceValidationExtension(project, isGpl = true) {

        override val jvmLinuxAndroidAarch64: String = "18d9428fae25a31b2479464ebf45af1b05e54cb212123f2f634f20c4e3d85dde"
        override val jvmLinuxAndroidArmv7: String = "7988fd6a09fbaa66604ef9664e6d1746fe7c2883432a53c953b745bd98b0a805"
        override val jvmLinuxAndroidX86: String = "b0e6902d5f49890e1a9e2775aff485dd933dca5f332ba6a3077998dd37ece2e1"
        override val jvmLinuxAndroidX86_64: String = "4e98950b08fd58055cef36d93861a9a8a4d2896edc71741ab24e046c6867f993"

        override val jvmLinuxLibcAarch64: String = "7a340e3ae631667fe61103c9dfb5bdf08b87da11e50475850720529e569123ef"
        override val jvmLinuxLibcArmv7: String = "285880a77a7b2dc67aa7fb21a5e3a4e869be45624ba0940616887dbb085ed239"
        override val jvmLinuxLibcPpc64: String = "28bba70c2b32dd3c877075628f6a9a65c98491dbae3cdc258a19f2480a742643"
        override val jvmLinuxLibcRiscv64: String = "cf6ec7c9825e878f2513f13673f485281833e97c6c719746852aa6e2094bd1fb"
        override val jvmLinuxLibcX86: String = "4611d0968f629b94eefcfa0b187eb488670ab936758f7bd7e1ad895c5b916768"
        override val jvmLinuxLibcX86_64: String = "f8750798f3362faffb9f3a616034fb466ab63539af3d1786746934ee49e6cbbc"

        override val jvmLinuxMuslAarch64: String = "96cdd8a0e459e68f0b1286ee142ea36a519e6f06d7254c3572f4b34a065b9f88"
        override val jvmLinuxMuslX86: String = "6f036a6984e58cc5349030280a372a4ac9b2fb17b050ac731918c44972f8ab2b"
        override val jvmLinuxMuslX86_64: String = "7b0021c67fcf5e68c3a43653bd7275498634868d6efe685e388936ea988816dd"

        override val jvmMacosAarch64: String = "5f6d3e565b4e7cd862199bf9f90eef2614f53f9cd7b7b3f9977569ee58bc1ab2"
        override val jvmMacosX86_64: String = "5bc7063133598013c7664fcba0bee700808172c28525d31bbda042aad63d3f43"

        override val jvmMingwX86: String = "f5d6a8ea8876768bb0e5a8db07cc1a5900dfbc4e47e5c62820c3129778695087"
        override val jvmMingwX86_64: String = "d2f03baf008e278f61b804af3c0dc0d38b4ef435519394f95e65478e6d2c26bb"

        override val nativeIosSimulatorArm64: String = "0c07a9b1ac3febbdac55890a06d9ddefdf62d86d896a7fe370a0142ec4eb5a9c"
        override val nativeIosX64: String = "56c169ec4cc842f5ed13ee9e505f278e8269848fffe246fa0c02579dd9783e63"

        override val nativeMacosArm64: String = "34d26f0823159b627f3d05809db21c04b14f74db292e0297c85e39c518c82603"
        override val nativeMacosX64: String = "2133b8935a63e4832940d16ae012d408b94be8a38f53bc5fdb7afb9029d8db52"

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
