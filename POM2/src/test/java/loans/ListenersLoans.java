package loans;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import frameWorkClasses.Utilities;

public class ListenersLoans implements ITestListener {

Utilities uts = new Utilities();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		System.out.println("This is a listeners START test " + result.getName());
		try {
			   uts.takeSnapShot("onTestSTART"+uts.timereturn()+".png");
			} catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		System.out.println("Success " + result.getName());
		try {
			   uts.takeSnapShot("onTestSuccess"+uts.timereturn()+".png");
			} catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failure " + result.getName());
		try {
			   uts.takeSnapShot("onTestFailure"+uts.timereturn()+".png");
			} catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		System.out.println("Skipped " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("OnStart ");
		try {
			   uts.takeSnapShot("TestOnStart "+uts.timereturn()+".png");
			} catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			}
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnStart ");
		try {
			   uts.takeSnapShot("TestonFinish "+uts.timereturn()+".png");
			} catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			}
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
}
