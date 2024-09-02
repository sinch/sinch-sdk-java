#!/bin/sh

if [ ! "${RELEASE_VERSION}"  ]; then
  echo "Missing 'RELEASE_VERSION' env value"
  exit 1
fi

if [ ! "${NEXT_VERSION}"  ]; then
  echo "Missing 'NEXT_VERSION' env value"
  exit 1
fi

if [ ! "${GITHUB_USERNAME}"  ]; then
  echo "Missing 'GITHUB_USERNAME' env value"
  exit 1
fi

if [ ! "${GITHUB_TOKEN}"  ]; then
  echo "Missing 'GITHUB_TOKEN' env value"
  exit 1
fi

SDKFILE_PATH="client/src/main/com/sinch/sdk/SDK.java"

NEXT_VERSION_SNAPSHOT="${NEXT_VERSION}-SNAPSHOT"
NEXT_VERSION_DEV="${NEXT_VERSION}-dev"

# Create SDK.java file with version information
SDK=$(java client/resources/SDKTemplate.java "$RELEASE_VERSION") && echo "$SDK" > "$SDKFILE_PATH" || exit 1
git add "$SDKFILE_PATH" && git commit -m "build (release): Bump version to $RELEASE_VERSION for sources" || exit 1

mvn --batch-mode -s settings.xml release:clean release:prepare \
  -Dtag="v$RELEASE_VERSION" \
  -DreleaseVersion="$RELEASE_VERSION" \
  -DdevelopmentVersion="${NEXT_VERSION_SNAPSHOT}" \
  -DscmReleaseCommitComment="[release] Set release & tag: $RELEASE_VERSION" \
  -DscmDevelopmentCommitComment="[release] Set next version: ${NEXT_VERSION_SNAPSHOT}"  || exit 1

mvn --batch-mode -s settings.xml release:perform \
  -Dusername="${GITHUB_USERNAME}" \
  -Dpassword="${GITHUB_TOKEN}" \
  -DskipTests=true  || exit 1

# Update SDK.java file with next version information
SDK=$(java client/resources/SDKTemplate.java "$NEXT_VERSION_DEV") && echo "$SDK" > "$SDKFILE_PATH" || exit 1
git add "$SDKFILE_PATH" && git commit -m "build (release): Set next version to $NEXT_VERSION_DEV for sources" || exit 1
git push -u origin HEAD || exit 1
