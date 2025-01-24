#!/bin/bash

artifact_id="${1:-gradle-java-template}"
group_id="${2:-org.eu.gonzalocaparros}"
version="${3:-0.1}"
package="$group_id.$(echo -n "$artifact_id" | tr -c '[:alnum:]' '_')"
package_folder="$(echo -n "$package" | tr '.' '/')"

export artifact_id group_id version package

repo_folder="${XDG_CACHE_HOME:-$HOME/.cache}/org.eu.gonzalocaparros"
repo_name="code-examples"
template_name="gradle-java-template"

if [[ ! -d $repo_folder/$repo_name ]]; then
    mkdir -p "$repo_folder"
    git -C "$repo_folder" clone "https://github.com/Gonzalocl/$repo_name.git"
else
    git -C "$repo_folder/$repo_name" pull
fi

function process_template_file() {
    template_file="$1"

    envsubst <"$repo_folder/$repo_name/$template_name/$template_file" >"$artifact_id/$template_file"
}

cp -r "$repo_folder/$repo_name/$template_name" "$artifact_id"
process_template_file "Readme.md"
process_template_file "build.gradle.kts"
process_template_file "settings.gradle.kts"
process_template_file "src/main/java/org/eu/gonzalocaparros/gradle_java_template/Main.java"
mkdir -p "$artifact_id/src/main/java/$package_folder"
mv "$artifact_id/src/main/java/org/eu/gonzalocaparros/gradle_java_template/Main.java" "$artifact_id/src/main/java/$package_folder"

git -C "$artifact_id" init
git -C "$artifact_id" add -A
git -C "$artifact_id" commit -m "New project"
