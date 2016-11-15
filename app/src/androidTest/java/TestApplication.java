import android.content.Context;

import com.abed.assignment.injection.component.TestApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;


public class TestApplication extends android.app.Application {

    TestApplicationComponent mApplicationComponent;


    public static TestApplication get(Context context) {
        return (TestApplication) context.getApplicationContext();
    }

    public TestApplicationComponent getComponent() {
//        if (mApplicationComponent == null) {
//            mApplicationComponent = DaggerApplicationComponent.builder()
//                    .applicationModule(new ApplicationModule(this))
//                    .build();
//        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(TestApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
