package com.clust4j.algo;

import org.apache.commons.math3.linear.AbstractRealMatrix;

import com.clust4j.utils.SimilarityMetric;

public abstract class AbstractDensityClusterer extends AbstractAutonomousClusterer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5645721633522621894L;

	public AbstractDensityClusterer(AbstractRealMatrix data, AbstractClusterer.BaseClustererPlanner planner) {
		super(data, planner);
		
		checkState(this);
	} // End constructor
	
	protected static void checkState(AbstractClusterer ac) {
		// Should not use similarity metrics in DBClusterers, DB looks for 
		// neighborhoods not accurately represented via similarity metrics.
		if(ac.getSeparabilityMetric() instanceof SimilarityMetric) {
			if(ac.verbose) ac.warn("density or radius-based clustering algorithms should use distance metrics instead of similarity metrics");
			else ac.flagWarning();
		}
	}
}
