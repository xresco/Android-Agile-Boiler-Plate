# ButterKnife 7

-dontwarn butterknife.internal.**
-dontwarn butterknife.Views$InjectViewProcessor
-dontwarn com.gc.materialdesign.views.**

-keep class butterknife.** { *; }
-keep class **$$ViewBinder { *; }
-keep class **$$ViewInjector { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}