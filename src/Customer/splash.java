package Customer;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class splash {
	
	/**
	 * constructor
	 * @wbp.parser.entryPoint
	 */
	public splash() {

		final GenericProgressDialog genericProgressDialog = new GenericProgressDialog("Test Callable");
		
		// ensure progress bar updates happen on the event dispatch thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				genericProgressDialog.setVisible(true);
			}
		});
		
		Set<Callable<Integer>> taskSet = new HashSet<Callable<Integer>>();

		// add a task to the set
		taskSet.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// sleep 3 seconds total, 1 second at a time
				for (int s = 0; s < 3; s++) { 
					System.out.println (s+1);
					Thread.sleep(500);
				}
				return 2;
			}
		});

		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (Callable<Integer> task : taskSet) {
			Future<Integer> future = executor.submit(task);
			// wait for result, then continue
			try {
				Integer result = future.get();
				System.out.println("Finished Task.  Result: " + result);
			} 
			catch (InterruptedException ie) {
				// thread was interrupted while waiting
				System.err.println("Thread interrupted, exiting.");
				ie.printStackTrace(System.err);
				break;
			} 
			catch (CancellationException ce) {
				// task was cancelled
				System.out.println("Task Cancelled");
			} 
			catch (ExecutionException ee) {
				// exception thrown in Callable<>.call()
				System.err.println("Exception thrown during task execution: ");
				// ee.getCause() is the exception thrown in the call() method
				ee.getCause().printStackTrace(System.err);
			}
		}

		executor.shutdown();
		
		genericProgressDialog.setVisible(false);
		LoginForm window = new LoginForm();
		window.frame.setVisible(true);
		genericProgressDialog.dispose();
		
	}
	
	/**
	 * a dialog box with progress bar
	 *
	 */
	public class GenericProgressDialog extends JDialog {

		public GenericProgressDialog(String title) {
	        
			final JProgressBar jProgressBar = new JProgressBar();
			jProgressBar.setIndeterminate(true);
			
			this.setTitle(title);
			this.setModal(true);

			this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			
			final int width = 500;
			final int height = 60;

			this.setPreferredSize(new Dimension(width, height));
			
			this.getContentPane().add(jProgressBar);
			
			this.setLocation( width/2, height/2 );
			
			this.pack();
			
		}
		
	}
	
	/**
	 * 
	 * @param s
	 */
	public static void main(String[] s) {

		new splash();

	}
}