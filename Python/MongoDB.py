# import pymongo

# client = pymongo.MongoClient('mongodb://localhost:27017')

# db = client["mydatabase"]

# collection = db["collection"]

# data = {"name" : "Aryansh", "Age" : 19}
# collection.insert_one(data)

# for x in collection.find():
#     print(x)
    
import pymongo

client = pymongo.MongoClient('mongodb://localhost:27017')

db = client["ap"]

collection = db["mycollection"]

# data = {"name" : "Shivanand", "Age" : 19}
# collection.insert_one(data)

collection.delete_one({"name" : "Shivanand"});