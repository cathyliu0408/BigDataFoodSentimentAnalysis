# Sentiment Analysis of Online Food Reviews Using Big Data Techniques

## Team Members
- **Jessica Yang** (zy1216)
- **Cathy Liu** (cyl4949)

## Project Overview

This project aims to perform sentiment analysis on a large volume of online food reviews to uncover insights into customer satisfaction and preferences. The motivation for this project stems from the increasing relevance of online reviews in shaping consumer preferences and business strategies, particularly in the food industry. By leveraging big data tools and techniques, we processed extensive datasets to develop a robust system capable of accurately classifying reviews into various sentiment categories.

## Motivation

The food industry is highly competitive and relies heavily on customer feedback. By understanding sentiments expressed in online reviews, businesses can tailor their services and products to better meet customer needs, enhancing their competitiveness and profitability. This project aims to transform raw review data into actionable business intelligence.

## Data Sources

We utilized two primary datasets for this project:
- **Yelp Open Dataset**: Nearly 6 million reviews related to over 188,000 businesses.
- **Amazon Fine Food Reviews Dataset**: Over 500,000 food product reviews.

## Methodology

Our approach involved several key stages:

1. **Data Ingestion**: Collecting data from Yelp and Amazon and storing it using Apache Hadoop's HDFS.
2. **Data Cleaning and Profiling**: Removing malformed entries, converting timestamps, and generating summary statistics using Apache Spark.
3. **Sentiment Analysis**: Utilizing NLP techniques and machine learning algorithms within the Apache Spark & MapReduce framework to classify reviews into positive, neutral, or negative sentiments.

### Tools and Technologies
- **Apache Hadoop**: For distributed data storage and processing.
- **Apache Spark**: For fast big data analytics.
- **Natural Language Processing (NLP)**: Techniques for text preprocessing and sentiment analysis.

## Key Findings

- Yelp reviews generally exhibit a higher frequency of positive sentiments compared to Amazon reviews.
- Temporal analysis indicates that positive sentiments peak during holiday seasons on both platforms.
- Service quality and food quality are predominant factors driving positive reviews on Yelp.
- Product quality and delivery experience are significant for Amazon reviews.

## Benefits

The insights from this project benefit both business owners and consumers. For businesses, the analysis guides them in understanding customer preferences and areas needing improvement. For consumers, it provides a summarized understanding of a restaurant's strengths and weaknesses, aiding them in making more informed dining choices.

## Conclusion

This project demonstrates the potential of big data technologies to drive strategic business decisions and improve service offerings in the competitive food industry. By providing businesses with precise, data-driven insights into customer feedback, our sentiment analysis helps prioritize areas for improvement and enhances customer satisfaction and loyalty.

## Code Structure

Here is a brief overview of the code files used in this project:

### Data Exploration
- `UniqueRecs.java`: Main driver for that finds out exploratory information of the Amazon dataset. 
- `UniqueRecsMapper.java`: Mapper class that finds out exploratory information of the Amazon daataset. 
- `UniqueRecsReducer.java`: Reducer class that finds out exploratory information of the Amazon dataset. 
- `FirstCode.scala`: Scala file that contains code on calculating mean, median, mode, standard deviation, and some data cleaning. 


### Data Cleaning

- `Clean.java`: Original Main driver for data cleaning on Amazon reviews.
- `CleanMapper.java`: Original Mapper class for cleaning on Amazon reviews.
- `CleanReducer.java`: Original Reducer class for cleaning Amazon reviews.
- `AmazonClean.java`: New Main driver for data cleaning on Amazon reviews.
- `AmazonCleanMapper.java`: New Mapper class for cleaning Amazon reviews.
- `AmazonCleanReducer.java`: New Reducer class for cleaning Amazon reviews.

### License

This project is licensed under the MIT License - see the LICENSE file for details.

### Sentiment Analysis

- `AmazonSentimentAnalysis.java`: Main driver for sentiment analysis on Amazon reviews.
- `AmazonSentimentMapper.java`: Mapper class for sentiment analysis on Amazon reviews.
- `AmazonSentimentReducer.java`: Reducer class for sentiment analysis on Amazon reviews.
