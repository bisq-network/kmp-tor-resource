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

    protected open val jvmLinuxAndroidAarch64: String = "f745c2730e33d12f943f7c86af9d23eb72cdbe5bb6e067781ca92f038b0c5b21"
    protected open val jvmLinuxAndroidArmv7: String = "1fa7ad916f7d44a51b023dbb963c71fdf839351afc8abfb6a760c22f83ef52c7"
    protected open val jvmLinuxAndroidX86: String = "74ca7e5e3406fe49ef73cb6b6dec4458f4457d042499965778035bd2247481bd"
    protected open val jvmLinuxAndroidX86_64: String = "5bc8633a909af8ad43c1be8b997d1a99ad5b6997271ddce18de90e8bb206d5a2"

    protected open val jvmLinuxLibcAarch64: String = "c31752a4fb32f6c580c6d5096cb50a3d19599d3c1d74bb26968874fd3d46d275"
    protected open val jvmLinuxLibcArmv7: String = "9de35f0f5202995048d7cfee0e0174452ae8374c44af87f355ca2889ef62872f"
    protected open val jvmLinuxLibcPpc64: String = "0e09230ff32bd322da4a7ebac12c6a9610e39241eb18c6716bc7c4efa45255fb"
    protected open val jvmLinuxLibcRiscv64: String = "c8b9c104b4ddb2e1b2bb70370168a84b8081ae0d00363336f89ff7a30a1b7efb"
    protected open val jvmLinuxLibcX86: String = "a8a2095743b5d77a8d942a4865208be182ec0f0d570b26942db8a0f9b0d6b86e"
    protected open val jvmLinuxLibcX86_64: String = "53a6f0865d3162e7088a82a6254227a59cd2f5099803b74d2b692654c9fa66ca"

    protected open val jvmLinuxMuslAarch64: String = "ba4c71d01a9bac97c8d8a2e72f4c416a785804581fe4411fa689b491dd1b38c4"
    protected open val jvmLinuxMuslX86: String = "0aafe1f66cddf2013d579939eeb0b5756fc75ed48952cda847aa39826cea5190"
    protected open val jvmLinuxMuslX86_64: String = "d5bac451e37eec57ebb6d5ee5bf516738ecd87a7599a0d674067f651c44a55ff"

    protected open val jvmMacosAarch64: String = "28a1d440c8a3484a664c470222c9586e61ed662ede14503e28e8a3e389063102"
    protected open val jvmMacosX86_64: String = "a1be03d81ca515fb405fc45cbebc8064c6569d943fd664f8130a95168fda20a9"

    protected open val jvmMingwX86: String = "256241dfe5abff49c027803cd5b0035459f44af184dc95475b6c8918b5f41142"
    protected open val jvmMingwX86_64: String = "71ff43f7a7d28b6fd4e2d4b589173f0f1f5440f84fd9a93c983c28bad547a61a"

    private val nativeLinuxArm64: String by lazy { jvmLinuxLibcAarch64 }
    private val nativeLinuxX64: String by lazy { jvmLinuxLibcX86_64 }

    protected open val nativeIosSimulatorArm64: String = "10cf8641ee464f7117d31d6fa20fab681679332ebae5d26336dbf6bd52e70380"
    protected open val nativeIosX64: String = "4882863f28e7e5596049f529f19084062d8360785c6707efc452f79ab639caab"

    protected open val nativeMacosArm64: String = "ac0aad11a6689d6def8902b884537010b2a0674834922dcc23a9276e47d1da40"
    protected open val nativeMacosX64: String = "911763111778de4c4dc184dece9da02dc8275c7ddfc27134138a7c3a1790f152"

    private val nativeMingwX64: String by lazy { jvmMingwX86_64 }

    /**
     * Resource validation and configuration for module `:library:resource-lib-tor-gpl`,
     * `tor` compiled with `--enable-gpl`.
     * */
    abstract class GPL @Inject internal constructor(
        project: Project,
    ): LibTorResourceValidationExtension(project, isGpl = true) {

        override val jvmLinuxAndroidAarch64: String = "dd0abc715473355d006aacff763a531dc2370daab0ee99807d1a8b3edadb201d"
        override val jvmLinuxAndroidArmv7: String = "b723e7b4b1f6d8f38b6bff26b7aee089bf2c9023220d1ad20576289e52fa1235"
        override val jvmLinuxAndroidX86: String = "613912444f46cb545024c721d032aaa178c1b5816e0bae90b28ba7f7b5525388"
        override val jvmLinuxAndroidX86_64: String = "adffac713377cf5066c504f22c3190225ebe2fa5152d6892dcb4c8af5cc95eee"

        override val jvmLinuxLibcAarch64: String = "8ac00b1c82364e75660671abca61524a32ee60955d1cdb2d378991f0c22e0467"
        override val jvmLinuxLibcArmv7: String = "f1262462e21138885f13ce6318c03db0969b8264ea50839718f5f181652263dc"
        override val jvmLinuxLibcPpc64: String = "89a1e14ea983bb0199094586d413146269ddcfa42c9877faeca0cda3885240fd"
        override val jvmLinuxLibcRiscv64: String = "594b1e91048623249e00f9c63028c0a1595afa4d2cd0c490a89bb8b4bc77cd83"
        override val jvmLinuxLibcX86: String = "c96a9e95798dad77e27508632fc92733ccba8cbd8b1683e14a479401a44ab605"
        override val jvmLinuxLibcX86_64: String = "6e5c482a61cf3589f2aaf9696cafb235c035d6fa1ee43486df4f5c5acdb07bac"

        override val jvmLinuxMuslAarch64: String = "6c391135470617be496e4ac137c2f3ccbbc66f99b7d0e700ee9b0b515351e2c6"
        override val jvmLinuxMuslX86: String = "68efa014315470234d635a26330069346eeab7e70fdf998100a02cca462a9ce4"
        override val jvmLinuxMuslX86_64: String = "b4a60e8b832abb295c9801d05c8f0551f5944ee625455199d1ec883805853a22"

        override val jvmMacosAarch64: String = "a9637f63f56edd9483a49a6975990b4aec9c718ad33e8042c9793d0228456ec6"
        override val jvmMacosX86_64: String = "8342f4e741bf11fb1f8ac1d162aa4ea25335e3cd8d2f1e4168fd1b10a601f67c"

        override val jvmMingwX86: String = "88452c1eabe0c5360eeb9e81138905c8e5a7fa92a549077dd33686e2a619676a"
        override val jvmMingwX86_64: String = "0fb52f7c2095429a21bbb6cf0ad071540ddee1855297495552a7e9cde5b99c45"

        override val nativeIosSimulatorArm64: String = "9fa984fe7d134afd053c27da479e0e73dfeed9cc4f285ae6b8ec779da3a12a28"
        override val nativeIosX64: String = "fe7bb1f2a27728960adc7611f1a63424e36e1e033d5966da65dfbf810fa37c60"

        override val nativeMacosArm64: String = "ae5c9a2a99785cb78054158c55e373d6f33f93a655c16ec5fcc23981c5317a39"
        override val nativeMacosX64: String = "4fba1f196c3717a8a31572bae371ccc8cac43ec635dd65f983031dda2b90d1db"

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
