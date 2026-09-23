/*
 * Copyright (c) 2023 Matthew Nelson
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
plugins {
    id("com.vanniktech.maven.publish")
}

// Bisq fork: publications go to a Maven layout under the root build directory, which the
// publish workflow commits to the gh-pages branch. Task name per module:
// publishAllPublicationsToGitHubPagesRepository
publishing {
    repositories {
        maven {
            name = "GitHubPages"
            url = uri(rootProject.layout.buildDirectory.dir("maven-repo"))
        }
    }
}

tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}
