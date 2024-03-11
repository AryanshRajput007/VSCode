import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import precision_recall_curve, f1_score

# Step 1: Read data from the Excel file
df = pd.read_csv('C:\\Users\\Aryansh Rajput\\Dropbox\\PC\\Downloads\\homeprices.csv')

# Step 2: Preprocess the data if necessary

# Step 3: Define a threshold for high and low prices
threshold = df['price'].mean()  # For example, using the mean price as the threshold

# Step 4: Convert prices to binary labels based on the threshold
df['price_class'] = np.where(df['price'] >= threshold, 1, 0)

# Step 5: Split the data into features (X) and target variable (y)
X = df[['area']]
y = df['price_class']

# Step 6: Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Step 7: Train a logistic regression model
model = LogisticRegression()
model.fit(X_train, y_train)

# Step 8: Make predictions on the test set
y_pred = model.predict(X_test)

# Step 9: Calculate precision, recall, and F1 score
precision, recall, thresholds = precision_recall_curve(y_test, y_pred)
f1 = f1_score(y_test, y_pred)

# Step 10: Plot precision, recall, and F1 score
plt.figure()
plt.plot(thresholds, precision[:-1], label='Precision')
plt.plot(thresholds, recall[:-1], label='Recall')
plt.plot(thresholds, [f1] * len(thresholds), label='F1 Score') # type: ignore
plt.xlabel('Threshold')
plt.ylabel('Score')
plt.title('Precision, Recall, and F1 Score vs. Threshold')
plt.legend()
plt.show()
