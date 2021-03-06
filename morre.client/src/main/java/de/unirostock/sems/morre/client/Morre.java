package de.unirostock.sems.morre.client;

import java.io.Serializable;
import java.util.List;

import de.unirostock.sems.morre.client.dataholder.AnnotationResult;
import de.unirostock.sems.morre.client.dataholder.ModelResult;
import de.unirostock.sems.morre.client.dataholder.PersonResult;
import de.unirostock.sems.morre.client.dataholder.PublicationResult;
import de.unirostock.sems.morre.client.exception.MorreClientException;
import de.unirostock.sems.morre.client.exception.MorreCommunicationException;
import de.unirostock.sems.morre.client.exception.MorreException;

/**
 * Interface for performing search queries to the <a href="http://sems.uni-rostock.de/projects/morre/">MORRE</a> database API
 * @author Martin Peters
 *
 */
public interface Morre extends Serializable {
	
	/**
	 * Searches for a model on the basis of a simple query.
	 *
	 * @param query String
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.ModelResult ModelResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<ModelResult> modelQuery( String query ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Returns the available features for a given query type.
	 *
	 * @param query the query
	 * @param aggregationType the aggregation type
	 * @param rankerWeights the ranker weights
	 * @return List of Strings with all available feature keywords
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<ModelResult> aggregatedModelQuery( String query, String aggregationType, String rankerWeights ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Returns the available features for a given query type and an aggregation type.
	 *
	 * @param queryType the query type
	 * @return List of Strings with all available feature keywords
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<String> getQueryFeatures( String queryType ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Performs a more complex query of the given type
	 * The available features can be retrieved by {@link #getQueryFeatures(String) getQueryFeatures}.
	 *
	 * @param queryType the query type
	 * @param features the features
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.ModelResult ModelResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<ModelResult> doModelQuery( String queryType, FeatureSet features ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Performs a simple query with only one keyword field for the given {@link de.unirostock.sems.morre.client.QueryType queryType}
	 * <b>Note:</b> Only some queryTypes are supporting this method!
	 *
	 * @param queryType the query type
	 * @param keyword String
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.ModelResult ModelResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<ModelResult> doSimpleModelQuery( String queryType, String keyword ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Searches for a Person on the basis of the given features
	 * The available features can be retrieved by {@link #getQueryFeatures(String) getQueryFeatures}.
	 *
	 * @param queryType the query type
	 * @param keyword the keyword
	 * @param aggregationType the aggregation type
	 * @param rankersWeights the rankers weights
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.PersonResult PersonResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<ModelResult> doSimpleAggregatedModelQuery(String queryType, String keyword, String aggregationType, String rankersWeights) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Searches for a Person on the basis of the given features
	 * The available features can be retrieved by {@link #getQueryFeatures(String) getQueryFeatures}.
	 *
	 * @param features the features
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.PersonResult PersonResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<PersonResult> doPersonQuery( FeatureSet features ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Searches for a Publication on the basis of the given features
	 * The available features can be retrieved by {@link #getQueryFeatures(String) getQueryFeatures}.
	 *
	 * @param features the features
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.PublicationResult PublicationResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<PublicationResult> doPublicationQuery( FeatureSet features ) throws MorreException, MorreClientException, MorreCommunicationException;
	
	/**
	 * Searches for Annotations on the basis of the given query String.
	 *
	 * @param query String
	 * @return List of {@link de.unirostock.sems.morre.client.dataholder.AnnotationResult AnnotationResults}
	 * @throws MorreException the morre exception
	 * @throws MorreClientException the morre client exception
	 * @throws MorreCommunicationException the morre communication exception
	 */
	public List<AnnotationResult> doAnnotationQuery( String query ) throws MorreException, MorreClientException, MorreCommunicationException;
	
}
