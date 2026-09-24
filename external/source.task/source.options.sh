#!/usr/bin/env bash
# Copyright (c) 2024 Matthew Nelson
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Sourced by external/task.sh

# TODO: Arg parser
readonly DRY_RUN="$(if [ "$1" = "--dry-run" ]; then echo "true"; else echo "false"; fi)"
readonly REBUILD="$(if [ "$1" = "--rebuild" ]; then echo "true"; else echo "false"; fi)"
# Packages Apple/Windows compilations without applying the detached code signatures from
# external/codesign. For contributors who cannot produce them (e.g. a tor version bump PR);
# the resulting hashes are of unsigned binaries and must not be released as-is.
readonly SKIP_CODESIGN="$(if [ "$1" = "--skip-codesign" ]; then echo "true"; else echo "false"; fi)"
# Like --skip-codesign, but gives the Apple compilations a deterministic ad-hoc signature with
# rcodesign instead of leaving them unsigned. Apple Silicon and the iOS Simulator refuse to load
# unsigned arm64 code, so this is what makes a fork's iOS Simulator and macOS binaries usable.
# Not a Developer ID signature: no notarization, no identity, so still not for distribution
# outside an app that Xcode re-signs.
readonly ADHOC_CODESIGN="$(if [ "$1" = "--adhoc-codesign" ]; then echo "true"; else echo "false"; fi)"
