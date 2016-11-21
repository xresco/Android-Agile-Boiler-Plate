# Proguard repo for used project libraries: https://github.com/krschultz/android-proguard-snippets
# Default Proguard.android.txt file: https://android.googlesource.com/platform/tools/base/+/HEAD/files/proguard-android.txt

# Keep all our project files
-keep class com.abed.assignment.** { *; }

# Uncomment to get better output
#-verbose

# Square uses this library and it gets removed from Proguard
# Ref: https://github.com/jakenjarvis/Android-OrmLiteContentProvider/issues/23
-libraryjars <java.home>/lib/rt.jar

# Square did it again...
# Ref: https://github.com/square/okio/issues/60
-dontwarn okio.**
-dontwarn org.apache.**
-dontwarn android.graphics.drawable.**
-dontwarn android.content.**
-dontwarn android.util.**
-dontwarn android.view.**
-dontobfuscate
# Remove logging
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static *** d(...);
    public static *** w(...);
    public static *** e(...);
    public static *** v(...);
    public static *** i(...);
    public static *** wtf(...);
}
