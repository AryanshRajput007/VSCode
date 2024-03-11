import pymongo

client = pymongo.MongoClient("mongodb://localhost:27017")
db = client["Student"]
collection = db["StudentData"]

data = [{"Name": "Shivanand", "Age": 19}, {"Name": "Aryansh", "Age": 19}, {"Name": "Kush", "Age": 19}, {"Name": "Aarzoo", "Age": 19}, {"Name": "Smith", "Age": 19}, {"Name": "Jay", "Age": 19}, {"Name": "Ansh", "Age": 19}, {"Name": "Vanshika" , "Age": 19}, {"Name": "Vishal", "Age": 19}]

for document in data:
    if collection.count_documents({"Name": document["Name"]}) == 0:
        collection.insert_one(document)
    else:
        print(f"Document with Name '{document['Name']}' already exists.")

query = {"Name": "Shivanand"}
cursor = collection.find(query)
for document in cursor:
    del document['_id']
    print(document)
