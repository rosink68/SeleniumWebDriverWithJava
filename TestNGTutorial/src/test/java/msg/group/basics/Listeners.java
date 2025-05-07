package msg.group.basics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// ITestListener interface which implements Testng listeners
public class Listeners implements ITestListener {

	/**
	 * Die Methoden werden nach Ausführung eines Scripts ausgeführt.
	 * 
	 * Bsp. 
	 * onTestFailure wird ausgeführt, wenn ein Test fehlschlägt.
	 * onTestSuccess wird nach jedem erfolgreichen Test ausgeführt.
	 */
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I successfully executed Listeners Pass code");
	}

	// ITestResult beschreibt das Testergebnis
	@Override
	public void onTestFailure(ITestResult result) {
		// result.getName() gibt den Namen der fehlgeschlagenen Methode zurück
		System.out.println("XXXXXX I failed executed Listeners Failure code in " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
}
