**CRUD Operations**



// Create- 50 Product Database

for (let i = 1; i <= 50; i++) {

&#x20;   db.products.insertOne({

&#x20;       productId: i,

&#x20;       productName: "Product " + i,

&#x20;       category: i % 5 === 0 ? "Laptop" :

&#x20;                 i % 5 === 1 ? "Mobile" :

&#x20;                 i % 5 === 2 ? "Headphones" :

&#x20;                 i % 5 === 3 ? "Keyboard" : "Mouse",

&#x20;       brand: i % 3 === 0 ? "Dell" :

&#x20;              i % 3 === 1 ? "Samsung" : "HP",

&#x20;       price: 1000 + (i \* 500),

&#x20;       stock: 10 + i,

&#x20;       rating: 3 + ((i % 3) \* 0.5),

&#x20;       inStock: i % 4 !== 0,

&#x20;       tags: \["electronics", i % 2 === 0 ? "featured" : "new"],

&#x20;       seller: {

&#x20;           sellerId: 1000 + i,

&#x20;           sellerName: "Seller " + i

&#x20;       },

&#x20;       createdAt: new Date()

&#x20;   });

}



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



//Read



// 1. Find all products in the Laptop category

db.products.find({ category: "Laptop" });



// 2. Find all products currently in stock

db.products.find({ inStock: true });



// 3. Find products with price greater than 20,000

db.products.find({ price: { $gt: 20000 } });



// 4. Find products with price between 10,000 and 30,000

db.products.find({ price: { $gte: 10000, $lte: 30000 } });



// 5. Find products sold by "Seller 10"

db.products.find({ "seller.sellerName": "Seller 10" });



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



// Update



// 1. Update single field: Set price of Product 1 to 10,000

db.products.updateOne(

&#x20;   { productId: 1 },

&#x20;   { $set: { price: 10000 } }

);



// 2. Increment numerical value: Increase stock of Product 6 by 20

db.products.updateOne(

&#x20;   { productId: 6 },

&#x20;   { $inc: { stock: 20 } }

);



// 3. Array update: Add "sale" to tags of Product 4

db.products.updateOne(

&#x20;   { productId: 4 },

&#x20;   { $push: { tags: "sale" } }

);



// 4. Update multiple documents: Increase price of all Samsung products by 1,000

db.products.updateMany(

&#x20;   { brand: "Samsung" },

&#x20;   { $inc: { price: 1000 } }

);



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



// Delete



// 1. Delete a single product with productId 10

db.products.deleteOne({ productId: 10 });



// 2. Delete all products belonging to "Laptop" category

db.products.deleteMany({ category: "Laptop" });



// 3. Delete all products with price greater than 30,000

db.products.deleteMany({ price: { $gt: 30000 } });



// 4. Delete all remaining documents in the collection

db.products.deleteMany({});



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-

\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



**AGGREGATION PIPELINE**



// Setup and Data insertion



// Program 1: Setup Database and Seed 5000 Documents



use ecomDB;

db.aggex.drop();



const categories = \["Electronics", "Mobiles", "Laptops", "Home Appliances", "Fashion", "Books", "Sports", "Beauty", "Grocery", "Furniture"];

const subCategories = {

&#x20;   "Electronics": \["Headphones", "Smartwatch", "Camera", "Speaker"],

&#x20;   "Mobiles": \["Android", "iPhone", "Feature Phone"],

&#x20;   "Laptops": \["Gaming", "Business", "Student"],

&#x20;   "Home Appliances": \["Refrigerator", "Washing Machine", "Microwave"],

&#x20;   "Fashion": \["Men", "Women", "Kids"],

&#x20;   "Books": \["Programming", "Fiction", "Education"],

&#x20;   "Sports": \["Cricket", "Football", "Fitness"],

&#x20;   "Beauty": \["Skincare", "Haircare", "Makeup"],

&#x20;   "Grocery": \["Snacks", "Beverages", "Staples"],

&#x20;   "Furniture": \["Chair", "Table", "Sofa"]

};

const brands = \["Samsung", "Apple", "Sony", "LG", "HP", "Dell", "Lenovo", "Nike", "Adidas", "Boat", "OnePlus", "AmazonBasics"];

const cities = \["Chennai", "Coimbatore", "Bangalore", "Hyderabad", "Mumbai", "Delhi", "Pune", "Kochi", "Kolkata", "Ahmedabad"];

const states = \["Tamil Nadu", "Karnataka", "Telangana", "Maharashtra", "Delhi", "Kerala", "West Bengal", "Gujarat"];

const paymentMethods = \["UPI", "Credit Card", "Debit Card", "Net Banking", "Cash on Delivery"];

const orderStatuses = \["Delivered", "Shipped", "Processing", "Cancelled", "Returned"];

const sellers = \["RetailHub", "TechWorld", "MegaStore", "DigitalMart", "SmartShop", "PrimeRetail"];

const tags = \["new", "popular", "trending", "premium", "budget", "best-seller", "discount", "limited-stock"];



let documents = \[];



for (let i = 1; i <= 5000; i++) {

&#x20;   const category = categories\[Math.floor(Math.random() \* categories.length)];

&#x20;   const subCategory = subCategories\[category]\[Math.floor(Math.random() \* subCategories\[category].length)];

&#x20;   const brand = brands\[Math.floor(Math.random() \* brands.length)];

&#x20;   const city = cities\[Math.floor(Math.random() \* cities.length)];

&#x20;   const state = states\[Math.floor(Math.random() \* states.length)];

&#x20;   const paymentMethod = paymentMethods\[Math.floor(Math.random() \* paymentMethods.length)];

&#x20;   const orderStatus = orderStatuses\[Math.floor(Math.random() \* orderStatuses.length)];

&#x20;   const seller = sellers\[Math.floor(Math.random() \* sellers.length)];

&#x20;   const quantity = Math.floor(Math.random() \* 5) + 1;

&#x20;   const price = Math.floor(Math.random() \* 95000) + 500;

&#x20;   const discount = Math.floor(Math.random() \* 51);

&#x20;   const discountedPrice = Math.round(price - (price \* discount / 100));

&#x20;   const rating = Number((Math.random() \* 4 + 1).toFixed(1));

&#x20;   const stock = Math.floor(Math.random() \* 500);



&#x20;   const selectedTags = \[

&#x20;       tags\[Math.floor(Math.random() \* tags.length)],

&#x20;       tags\[Math.floor(Math.random() \* tags.length)]

&#x20;   ];



&#x20;   const startDate = new Date("2024-01-01").getTime();

&#x20;   const endDate = new Date("2026-08-25").getTime();

&#x20;   const randomDate = new Date(startDate + Math.random() \* (endDate - startDate));



&#x20;   const product = {

&#x20;       productId: "PROD" + String(i).padStart(5, "0"),

&#x20;       productName: brand + " " + subCategory + " " + i,

&#x20;       category: category,

&#x20;       subCategory: subCategory,

&#x20;       brand: brand,

&#x20;       price: price,

&#x20;       discountPercentage: discount,

&#x20;       discountedPrice: discountedPrice,

&#x20;       quantity: quantity,

&#x20;       revenue: discountedPrice \* quantity,

&#x20;       rating: rating,

&#x20;       reviewCount: Math.floor(Math.random() \* 5000),

&#x20;       stock: stock,

&#x20;       inStock: stock > 0,

&#x20;       seller: {

&#x20;           name: seller,

&#x20;           sellerRating: Number((Math.random() \* 4 + 1).toFixed(1))

&#x20;       },

&#x20;       customer: {

&#x20;           customerId: "CUS" + String(Math.floor(Math.random() \* 1000) + 1).padStart(4, "0"),

&#x20;           city: city,

&#x20;           state: state,

&#x20;           age: Math.floor(Math.random() \* 50) + 18

&#x20;       },

&#x20;       payment: {

&#x20;           method: paymentMethod,

&#x20;           transactionId: "TXN" + Math.random().toString(36).substring(2, 12)

&#x20;       },

&#x20;       orderStatus: orderStatus,

&#x20;       orderDate: randomDate,

&#x20;       tags: selectedTags,

&#x20;       specifications: {

&#x20;           warranty: (Math.floor(Math.random() \* 3) + 1) + " years",

&#x20;           color: \["Black", "White", "Blue", "Red", "Silver"]\[Math.floor(Math.random() \* 5)],

&#x20;           weight: Number((Math.random() \* 5 + 0.5).toFixed(2))

&#x20;       },

&#x20;       isFeatured: Math.random() > 0.7,

&#x20;       createdAt: new Date()

&#x20;   };



&#x20;   documents.push(product);



&#x20;   if (documents.length === 500) {

&#x20;       db.aggex.insertMany(documents);

&#x20;       documents = \[];

&#x20;   }

}



if (documents.length > 0) {

&#x20;   db.aggex.insertMany(documents);

}



print("Successfully inserted 5,000 documents into the aggex collection!");



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



// Program 2: Filtering, Field Selection, and Transformation Operations



// 1. $match: Filter products in 'Electronics' category with price > 50,000

db.aggex.aggregate(\[

&#x20;   {

&#x20;       $match: {

&#x20;           category: "Electronics",

&#x20;           price: { $gt: 50000 }

&#x20;       }

&#x20;   }

]);



// 2. $project: Reshape output to show selected fields and computed totalValue

db.aggex.aggregate(\[

&#x20;   {

&#x20;       $project: {

&#x20;           productName: 1,

&#x20;           price: 1,

&#x20;           quantity: 1,

&#x20;           totalValue: { $multiply: \["$price", "$quantity"] }

&#x20;       }

&#x20;   }

]);



// 3. $addFields / $set: Dynamically attach computed fields to full document

db.aggex.aggregate(\[

&#x20;   {

&#x20;       $addFields: {

&#x20;           totalValue: { $multiply: \["$price", "$quantity"] }

&#x20;       }

&#x20;   }

]);



// 4. $count: Get the total count of documents matching criteria

db.aggex.aggregate(\[

&#x20;   { $match: { category: "Electronics" } },

&#x20;   { $count: "totalElectronicsProducts" }

]);



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



// Program 3: Data Aggregation, Pagination, and Array Processing



// 1. $group: Group by category and compute counts, total quantity, and average price

db.aggex.aggregate(\[

&#x20;   {

&#x20;       $group: {

&#x20;           \_id: "$category",

&#x20;           totalProducts: { $sum: 1 },

&#x20;           totalQuantity: { $sum: "$quantity" },

&#x20;           averagePrice: { $avg: "$price" }

&#x20;       }

&#x20;   }

]);



// 2. $sort, $skip, $limit: Sorting and Pagination (e.g., Get top 2-4 expensive products)

db.aggex.aggregate(\[

&#x20;   { $sort: { price: -1 } },

&#x20;   { $skip: 2 },

&#x20;   { $limit: 2 }

]);



// 3. $unwind: Deconstruct array elements (tags) into individual document stream

db.aggex.aggregate(\[

&#x20;   { $unwind: "$tags" },

&#x20;   { $project: { productName: 1, tags: 1 } }

]);



// 4. $lookup: Perform SQL-like JOIN between orders and customer collection

db.aggex.aggregate(\[

&#x20;   {

&#x20;       $lookup: {

&#x20;           from: "customers",

&#x20;           localField: "customer.customerId",

&#x20;           foreignField: "customerId",

&#x20;           as: "customerDetails"

&#x20;       }

&#x20;   }

]);



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



// Program 4: Advanced Multi-Stage Aggregation Pipeline

// Requirement: Find top 3 most expensive Electronics products and output simplified fields



db.aggex.aggregate(\[

&#x20;   {

&#x20;       $match: {

&#x20;           category: "Electronics"

&#x20;       }

&#x20;   },

&#x20;   {

&#x20;       $sort: {

&#x20;           price: -1

&#x20;       }

&#x20;   },

&#x20;   {

&#x20;       $limit: 3

&#x20;   },

&#x20;   {

&#x20;       $project: {

&#x20;           \_id: 0,

&#x20;           productName: 1,

&#x20;           price: 1,

&#x20;           brand: 1

&#x20;       }

&#x20;   }

]);



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



for (let i = 1; i <= 50; i++) {

&#x20;   db.users.insertOne({

&#x20;       userId: 2000 + i,

&#x20;       name: "User " + i,

&#x20;       email: "user" + i + "@example.com",

&#x20;       

&#x20;       // Rotates through 4 roles: admin, editor, seller, customer

&#x20;       role: 

&#x20;           i % 4 === 0 ? "admin" :

&#x20;           i % 4 === 1 ? "editor" :

&#x20;           i % 4 === 2 ? "seller" : 

&#x20;                         "customer",



&#x20;       // Alternates membership tiers based on modulo

&#x20;       membership: 

&#x20;           i % 3 === 0 ? "Gold" :

&#x20;           i % 3 === 1 ? "Silver" : 

&#x20;                         "Bronze",



&#x20;       age: 20 + (i % 30), // Ages ranging from 20 to 49



&#x20;       rewardPoints: i \* 150, // Scaled values from 150 to 7500



&#x20;       isActive: i % 5 !== 0, // Every 5th user is set to inactive (false)



&#x20;       // Dynamic array for account preferences

&#x20;       interests: \[

&#x20;           "shopping",

&#x20;           i % 2 === 0 ? "tech" : "fashion"

&#x20;       ],



&#x20;       // Nested embedded document for user address

&#x20;       address: {

&#x20;           city: 

&#x20;               i % 3 === 0 ? "New York" :

&#x20;               i % 3 === 1 ? "London" : 

&#x20;                             "Tokyo",

&#x20;           zipCode: 10000 + (i \* 12)

&#x20;       },



&#x20;       lastLogin: new Date()

&#x20;   });

}



for (let i = 1; i <= 50; i++) {



&#x20;    db.products.insertOne({

&#x20;        productId: i,

&#x20;        productName: "Product " + i ,

&#x20;        category:

&#x20;            i % 5 === 0 ? "Laptop" :

&#x20;            i % 5 === 1 ? "Mobile" :

&#x20;            i % 5 === 2 ? "Headphones" :

&#x20;            i % 5 === 3 ? "Keyboard" :

&#x20;                          "Mouse",



&#x20;        brand:

&#x20;            i % 3 === 0 ? "Dell" :

&#x20;            i % 3 === 1 ? "Samsung" :

&#x20;                          "HP",



&#x20;        price: 1000 + (i \* 500),



&#x20;        stock: 10 + i,



&#x20;        rating: 3 + ((i % 3) \* 0.5),



&#x20;        inStock: i % 4 !== 0,



&#x20;        tags: \[

&#x20;            "electronics",

&#x20;            i % 2 === 0 ? "featured" : "new"

&#x20;        ],



&#x20;        seller: {

&#x20;            sellerId: 1000 + i,

&#x20;            sellerName: "Seller " + i

&#x20;        },



&#x20;        createdAt: new Date()

&#x20;    });

&#x20;}



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



db.students.insertMany(\[

&#x20;    { studentId: 1, name: "Vinay", branch: "CSE", cgpa: 8.1, skills: \["Java", "MongoDB"] },

&#x20;    { studentId: 2, name: "Suraj", branch: "AI/DS", cgpa: 7.3, skills: \["Python", "C"] },

&#x20;    { studentId: 3, name: "Priyansh", branch: "IT", cgpa: 8.1, skills: \["Python", "AI"] },

&#x20;    { studentId: 4, name: "Nehal", branch: "ECE", cgpa: 6.5, skills: \["C", "Embedded"] },

&#x20;    { studentId: 5, name: "Rohan", branch: "CSE", cgpa: 7.0, skills: \["Java", "SQL"] },

&#x20;    { studentId: 6, name: "Anuj", branch: "IT", cgpa: 9.3, skills: \["Python", "Data Science"] },

&#x20;    { studentId: 7, name: "Kabir", branch: "ME", cgpa: 10, skills: \["AutoCAD"] },

&#x20;    { studentId: 8, name: "Sonam", branch: "CSE", cgpa: 9.1, skills: \["Java", "Spring Boot"] },

&#x20;    { studentId: 9, name: "Suhash", branch: "ECE", cgpa: 8.6, skills: \["C", "IoT"] },

&#x20;    { studentId: 10, name: "Poonam", branch: "IT", cgpa: 8.0, skills: \["JavaScript", "React"] },

&#x20;    { studentId: 11, name: "Arihant", branch: "CSE", cgpa: 9.9, skills: \["Python", "Django"] },

&#x20;    { studentId: 12, name: "Simraa", branch: "ME", cgpa: 7.4, skills: \["SolidWorks"] },

&#x20;    { studentId: 13, name: "Nikita", branch: "ECE", cgpa: 6.1, skills: \["Python", "IoT"] },

&#x20;    { studentId: 14, name: "Kavyansh", branch: "IT", cgpa: 7.0, skills: \["Java", "MongoDB"] },

&#x20;    { studentId: 15, name: "Mohan", branch: "CSE", cgpa: 6.7, skills: \["C++", "DSA"] }

&#x20;])

**{**

&#x20; **acknowledged: true,**

&#x20; **insertedIds: {**

&#x20;   **'0': ObjectId('6aa0cd2278c9f666ca041725'),**

&#x20;   **'1': ObjectId('6aa0cd2278c9f666ca041726'),**

&#x20;   **'2': ObjectId('6aa0cd2278c9f666ca041727'),**

&#x20;   **'3': ObjectId('6aa0cd2278c9f666ca041728'),**

&#x20;   **'4': ObjectId('6aa0cd2278c9f666ca041729'),**

&#x20;   **'5': ObjectId('6aa0cd2278c9f666ca04172a'),**

&#x20;   **'6': ObjectId('6aa0cd2278c9f666ca04172b'),**

&#x20;   **'7': ObjectId('6aa0cd2278c9f666ca04172c'),**

&#x20;   **'8': ObjectId('6aa0cd2278c9f666ca04172d'),**

&#x20;   **'9': ObjectId('6aa0cd2278c9f666ca04172e'),**

&#x20;   **'10': ObjectId('6aa0cd2278c9f666ca04172f'),**

&#x20;   **'11': ObjectId('6aa0cd2278c9f666ca041730'),**

&#x20;   **'12': ObjectId('6aa0cd2278c9f666ca041731'),**

&#x20;   **'13': ObjectId('6aa0cd2278c9f666ca041732'),**

&#x20;   **'14': ObjectId('6aa0cd2278c9f666ca041733')**

&#x20; **}**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



db.companies.insertMany(\[

&#x20;    { companyId: 1, companyName: "TCS", location: "Pune", industry: "IT" },

&#x20;    { companyId: 2, companyName: "Infosys", location: "Bangalore", industry: "IT" },

&#x20;    { companyId: 3, companyName: "Wipro", location: "Hyderabad", industry: "IT" },

&#x20;    { companyId: 4, companyName: "Accenture", location: "Mumbai", industry: "IT" },

&#x20;    { companyId: 5, companyName: "Microsoft", location: "Bangalore", industry: "Technology" }

&#x20;])

**{**

&#x20; **acknowledged: true,**

&#x20; **insertedIds: {**

&#x20;   **'0': ObjectId('6aa0cd3078c9f666ca041734'),**

&#x20;   **'1': ObjectId('6aa0cd3078c9f666ca041735'),**

&#x20;   **'2': ObjectId('6aa0cd3078c9f666ca041736'),**

&#x20;   **'3': ObjectId('6aa0cd3078c9f666ca041737'),**

&#x20;   **'4': ObjectId('6aa0cd3078c9f666ca041738')**

&#x20; **}**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



db.jobs.insertMany(\[

&#x20;    {

&#x20;        jobId: 101,

&#x20;        companyId: 1,

&#x20;        jobTitle: "Software Developer",

&#x20;        requiredBranch: "CSE",

&#x20;        minimumCGPA: 7.5,

&#x20;        salary: 600000

&#x20;    },

&#x20;    {

&#x20;       jobId: 102,

&#x20;        companyId: 2,

&#x20;        jobTitle: "System Engineer",

&#x20;        requiredBranch: "CSE",

&#x20;        minimumCGPA: 7.0,

&#x20;        salary: 550000

&#x20;    },

&#x20;    {

&#x20;        jobId: 103,

&#x20;        companyId: 3,

&#x20;        jobTitle: "Python Developer",

&#x20;        requiredBranch: "IT",

&#x20;        minimumCGPA: 7.5,

&#x20;        salary: 650000

&#x20;    },

&#x20;    {

&#x20;        jobId: 104,

&#x20;        companyId: 4,

&#x20;        jobTitle: "Data Analyst",

&#x20;        requiredBranch: "IT",

&#x20;        minimumCGPA: 8.0,

&#x20;        salary: 700000

&#x20;    },

&#x20;    {

&#x20;        jobId: 105,

&#x20;        companyId: 5,

&#x20;        jobTitle: "Software Engineer",

&#x20;        requiredBranch: "CSE",

&#x20;        minimumCGPA: 8.5,

&#x20;        salary: 1500000

&#x20;    }

&#x20;])

**{**

&#x20; **acknowledged: true,**

&#x20; **insertedIds: {**

&#x20;   **'0': ObjectId('6aa0cd4878c9f666ca041739'),**

&#x20;   **'1': ObjectId('6aa0cd4878c9f666ca04173a'),**

&#x20;   **'2': ObjectId('6aa0cd4878c9f666ca04173b'),**

&#x20;   **'3': ObjectId('6aa0cd4878c9f666ca04173c'),**

&#x20;   **'4': ObjectId('6aa0cd4878c9f666ca04173d')**

&#x20; **}**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



db.jobs.insertMany(\[

&#x20;    {

&#x20;        jobId: 101,

&#x20;        companyId: 1,

&#x20;        jobTitle: "Software Developer",

&#x20;        requiredBranch: "CSE",

&#x20;        minimumCGPA: 7.5,

&#x20;        salary: 600000

&#x20;    },

&#x20;    {

&#x20;        jobId: 102,

&#x20;        companyId: 2,

&#x20;        jobTitle: "System Engineer",

&#x20;        requiredBranch: "CSE",

&#x20;        minimumCGPA: 7.0,

&#x20;        salary: 550000

&#x20;    },

&#x20;    {

&#x20;        jobId: 103,

&#x20;        companyId: 3,

&#x20;        jobTitle: "Python Developer",

&#x20;        requiredBranch: "IT",

&#x20;        minimumCGPA: 7.5,

&#x20;        salary: 650000

&#x20;    },

&#x20;    {

&#x20;        jobId: 104,

&#x20;        companyId: 4,

&#x20;        jobTitle: "Data Analyst",

&#x20;        requiredBranch: "IT",

&#x20;        minimumCGPA: 8.0,

&#x20;        salary: 700000

&#x20;    },

&#x20;    {

&#x20;        jobId: 105,

&#x20;        companyId: 5,

&#x20;        jobTitle: "Software Engineer",

&#x20;        requiredBranch: "CSE",

&#x20;        minimumCGPA: 8.5,

&#x20;        salary: 1500000

&#x20;    }

&#x20;])

**{**

&#x20; **acknowledged: true,**

&#x20; **insertedIds: {**

&#x20;   **'0': ObjectId('6aa0cd5378c9f666ca04173e'),**

&#x20;   **'1': ObjectId('6aa0cd5378c9f666ca04173f'),**

&#x20;   **'2': ObjectId('6aa0cd5378c9f666ca041740'),**

&#x20;   **'3': ObjectId('6aa0cd5378c9f666ca041741'),**

&#x20;   **'4': ObjectId('6aa0cd5378c9f666ca041742')**

&#x20; **}**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



db.students.insertMany(\[

&#x20;    { studentId: 16, name: "Ritika", branch: "CSE", cgpa: 8.4, skills: \["Java", "React"] },

&#x20;    { studentId: 17, name: "Suresh", branch: "ME", cgpa: 7.3, skills: \["AutoCAD", "SolidWorks"] },

&#x20;    { studentId: 18, name: "Divya", branch: "IT", cgpa: 9.2, skills: \["Python", "Machine Learning"] },

&#x20;    { studentId: 19, name: "Manoj", branch: "ECE", cgpa: 7.7, skills: \["Embedded", "C"] },

&#x20;    { studentId: 20, name: "Shreya", branch: "CSE", cgpa: 8.6, skills: \["JavaScript", "Node.js"] },

&#x20;    { studentId: 21, name: "Abhishek", branch: "ME", cgpa: 6.9, skills: \["AutoCAD"] },

&#x20;    { studentId: 22, name: "Meena", branch: "IT", cgpa: 8.0, skills: \["SQL", "Power BI"] },

&#x20;    { studentId: 23, name: "Rajesh", branch: "ECE", cgpa: 7.5, skills: \["IoT", "C++"] },

&#x20;   { studentId: 24, name: "Isha", branch: "CSE", cgpa: 9.3, skills: \["Java", "Spring Boot"] },

&#x20;    { studentId: 25, name: "Deepak", branch: "IT", cgpa: 8.1, skills: \["Python", "SQL"] }

&#x20;])



**{**

&#x20; **acknowledged: true,**

&#x20; **insertedIds: {**

&#x20;   **'0': ObjectId('6aa0ce0078c9f666ca041743'),**

&#x20;   **'1': ObjectId('6aa0ce0078c9f666ca041744'),**

&#x20;   **'2': ObjectId('6aa0ce0078c9f666ca041745'),**

&#x20;   **'3': ObjectId('6aa0ce0078c9f666ca041746'),**

&#x20;   **'4': ObjectId('6aa0ce0078c9f666ca041747'),**

&#x20;   **'5': ObjectId('6aa0ce0078c9f666ca041748'),**

&#x20;   **'6': ObjectId('6aa0ce0078c9f666ca041749'),**

&#x20;   **'7': ObjectId('6aa0ce0078c9f666ca04174a'),**

&#x20;   **'8': ObjectId('6aa0ce0078c9f666ca04174b'),**

&#x20;   **'9': ObjectId('6aa0ce0078c9f666ca04174c')**

&#x20; **}**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



db.companies.insertMany(\[

&#x20;   { companyId: 1, companyName: "TCS", location: "Pune", industry: "IT" },

&#x20;    { companyId: 2, companyName: "Infosys", location: "Bangalore", industry: "IT" },

&#x20;    { companyId: 3, companyName: "Wipro", location: "Hyderabad", industry: "IT" },

&#x20;    { companyId: 4, companyName: "Accenture", location: "Mumbai", industry: "IT" },

&#x20;    { companyId: 5, companyName: "Microsoft", location: "Bangalore", industry: "Technology" }

&#x20;])

**{**

&#x20; **acknowledged: true,**

&#x20; **insertedIds: {**

&#x20;   **'0': ObjectId('6aa0dca878c9f666ca04174d'),**

&#x20;   **'1': ObjectId('6aa0dca878c9f666ca04174e'),**

&#x20;   **'2': ObjectId('6aa0dca878c9f666ca04174f'),**

&#x20;   **'3': ObjectId('6aa0dca878c9f666ca041750'),**

&#x20;   **'4': ObjectId('6aa0dca878c9f666ca041751')**

&#x20; **}**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



show collections

products

for (let i = 1; i <= 50; i++) {



&#x20;    db.products.insertOne({

&#x20;        productId: i,

&#x20;        productName: "Product " + i ,

&#x20;        category:

&#x20;            i % 5 === 0 ? "Laptop" :

&#x20;            i % 5 === 1 ? "Mobile" :

&#x20;            i % 5 === 2 ? "Headphones" :

&#x20;            i % 5 === 3 ? "Keyboard" :

&#x20;                          "Mouse",



&#x20;        brand:

&#x20;            i % 3 === 0 ? "Dell" :

&#x20;            i % 3 === 1 ? "Samsung" :

&#x20;                          "HP",



&#x20;        price: 1000 + (i \* 500),



&#x20;        stock: 10 + i,



&#x20;        rating: 3 + ((i % 3) \* 0.5),



&#x20;        inStock: i % 4 !== 0,



&#x20;        tags: \[

&#x20;            "electronics",

&#x20;            i % 2 === 0 ? "featured" : "new"

&#x20;        ],



&#x20;        seller: {

&#x20;            sellerId: 1000 + i,

&#x20;            sellerName: "Seller " + i

&#x20;        },



&#x20;        createdAt: new Date()

&#x20;    });

&#x20;}



**{**

&#x20; **acknowledged: true,**

&#x20; **insertedId: ObjectId('6aa0dd1678c9f666ca041783')**

**}**



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.countDocuments()

50

Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.find({

&#x20;  category: "laptop",

&#x20;  inStock: true

&#x20;})





Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.find({

&#x20;  category: "laptop",

&#x20;  stockQuantity: { $gt: 0 }

&#x20;})





Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.find({

&#x20;  price: { $gt: 10000, $lt: 30000 }

&#x20;})



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



\[

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca041764'),

&#x20;   productId: 19,

&#x20;   productName: 'Product 19',

&#x20;   category: 'Mouse',

&#x20;   brand: 'Samsung',

&#x20;   price: 10500,

&#x20;   stock: 29,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1019, sellerName: 'Seller 19' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.898Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca041765'),

&#x20;   productId: 20,

&#x20;   productName: 'Product 20',

&#x20;   category: 'Laptop',

&#x20;   brand: 'HP',

&#x20;   price: 11000,

&#x20;   stock: 30,

&#x20;   rating: 4,

&#x20;   inStock: false,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1020, sellerName: 'Seller 20' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.972Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041766'),

&#x20;   productId: 21,

&#x20;   productName: 'Product 21',

&#x20;   category: 'Mobile',

&#x20;   brand: 'Dell',

&#x20;   price: 11500,

&#x20;   stock: 31,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1021, sellerName: 'Seller 21' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.045Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041767'),

&#x20;   productId: 22,

&#x20;   productName: 'Product 22',

&#x20;   category: 'Headphones',

&#x20;   brand: 'Samsung',

&#x20;   price: 12000,

&#x20;   stock: 32,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1022, sellerName: 'Seller 22' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.140Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041768'),

&#x20;   productId: 23,

&#x20;   productName: 'Product 23',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'HP',

&#x20;   price: 12500,

&#x20;   stock: 33,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1023, sellerName: 'Seller 23' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.248Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041769'),

&#x20;   productId: 24,

&#x20;   productName: 'Product 24',

&#x20;   category: 'Mouse',

&#x20;   brand: 'Dell',

&#x20;   price: 13000,

&#x20;   stock: 34,

&#x20;   rating: 3,

&#x20;   inStock: false,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1024, sellerName: 'Seller 24' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.386Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176a'),

&#x20;   productId: 25,

&#x20;   productName: 'Product 25',

&#x20;   category: 'Laptop',

&#x20;   brand: 'Samsung',

&#x20;   price: 13500,

&#x20;   stock: 35,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1025, sellerName: 'Seller 25' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.482Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176b'),

&#x20;   productId: 26,

&#x20;   productName: 'Product 26',

&#x20;   category: 'Mobile',

&#x20;   brand: 'HP',

&#x20;   price: 14000,

&#x20;   stock: 36,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1026, sellerName: 'Seller 26' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.559Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176c'),

&#x20;   productId: 27,

&#x20;   productName: 'Product 27',

&#x20;   category: 'Headphones',

&#x20;   brand: 'Dell',

&#x20;   price: 14500,

&#x20;   stock: 37,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1027, sellerName: 'Seller 27' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.650Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176d'),

&#x20;   productId: 28,

&#x20;   productName: 'Product 28',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'Samsung',

&#x20;   price: 15000,

&#x20;   stock: 38,

&#x20;   rating: 3.5,

&#x20;   inStock: false,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1028, sellerName: 'Seller 28' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.731Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176e'),

&#x20;   productId: 29,

&#x20;   productName: 'Product 29',

&#x20;   category: 'Mouse',

&#x20;   brand: 'HP',

&#x20;   price: 15500,

&#x20;   stock: 39,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1029, sellerName: 'Seller 29' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.820Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176f'),

&#x20;   productId: 30,

&#x20;   productName: 'Product 30',

&#x20;   category: 'Laptop',

&#x20;   brand: 'Dell',

&#x20;   price: 16000,

&#x20;   stock: 40,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1030, sellerName: 'Seller 30' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.935Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041770'),

&#x20;   productId: 31,

&#x20;   productName: 'Product 31',

&#x20;   category: 'Mobile',

&#x20;   brand: 'Samsung',

&#x20;   price: 16500,

&#x20;   stock: 41,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1031, sellerName: 'Seller 31' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.012Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041771'),

&#x20;   productId: 32,

&#x20;   productName: 'Product 32',

&#x20;   category: 'Headphones',

&#x20;   brand: 'HP',

&#x20;   price: 17000,

&#x20;   stock: 42,

&#x20;   rating: 4,

&#x20;   inStock: false,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1032, sellerName: 'Seller 32' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.126Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041772'),

&#x20;   productId: 33,

&#x20;   productName: 'Product 33',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'Dell',

&#x20;   price: 17500,

&#x20;   stock: 43,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1033, sellerName: 'Seller 33' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.230Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041773'),

&#x20;   productId: 34,

&#x20;   productName: 'Product 34',

&#x20;   category: 'Mouse',

&#x20;   brand: 'Samsung',

&#x20;   price: 18000,

&#x20;   stock: 44,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1034, sellerName: 'Seller 34' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.366Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041774'),

&#x20;   productId: 35,

&#x20;   productName: 'Product 35',

&#x20;   category: 'Laptop',

&#x20;   brand: 'HP',

&#x20;   price: 18500,

&#x20;   stock: 45,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1035, sellerName: 'Seller 35' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.453Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041775'),

&#x20;   productId: 36,

&#x20;   productName: 'Product 36',

&#x20;   category: 'Mobile',

&#x20;   brand: 'Dell',

&#x20;   price: 19000,

&#x20;   stock: 46,

&#x20;   rating: 3,

&#x20;   inStock: false,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1036, sellerName: 'Seller 36' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.571Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041776'),

&#x20;   productId: 37,

&#x20;   productName: 'Product 37',

&#x20;   category: 'Headphones',

&#x20;   brand: 'Samsung',

&#x20;   price: 19500,

&#x20;   stock: 47,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1037, sellerName: 'Seller 37' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.687Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1478c9f666ca041777'),

&#x20;   productId: 38,

&#x20;   productName: 'Product 38',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'HP',

&#x20;   price: 20000,

&#x20;   stock: 48,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1038, sellerName: 'Seller 38' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:12.812Z')

&#x20; }

]

Type "it" for more

Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.find({

&#x20;  category: "laptop"

&#x20;})





Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.find({

&#x20;  inStock: true

&#x20;})

\[

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca041752'),

&#x20;   productId: 1,

&#x20;   productName: 'Product 1',

&#x20;   category: 'Mobile',

&#x20;   brand: 'Samsung',

&#x20;   price: 1500,

&#x20;   stock: 11,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1001, sellerName: 'Seller 1' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.028Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca041753'),

&#x20;   productId: 2,

&#x20;   productName: 'Product 2',

&#x20;   category: 'Headphones',

&#x20;   brand: 'HP',

&#x20;   price: 2000,

&#x20;   stock: 12,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1002, sellerName: 'Seller 2' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.144Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca041754'),

&#x20;   productId: 3,

&#x20;   productName: 'Product 3',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'Dell',

&#x20;   price: 2500,

&#x20;   stock: 13,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1003, sellerName: 'Seller 3' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.222Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca041756'),

&#x20;   productId: 5,

&#x20;   productName: 'Product 5',

&#x20;   category: 'Laptop',

&#x20;   brand: 'HP',

&#x20;   price: 3500,

&#x20;   stock: 15,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1005, sellerName: 'Seller 5' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.417Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca041757'),

&#x20;   productId: 6,

&#x20;   productName: 'Product 6',

&#x20;   category: 'Mobile',

&#x20;   brand: 'Dell',

&#x20;   price: 4000,

&#x20;   stock: 16,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1006, sellerName: 'Seller 6' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.527Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca041758'),

&#x20;   productId: 7,

&#x20;   productName: 'Product 7',

&#x20;   category: 'Headphones',

&#x20;   brand: 'Samsung',

&#x20;   price: 4500,

&#x20;   stock: 17,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1007, sellerName: 'Seller 7' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.623Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca04175a'),

&#x20;   productId: 9,

&#x20;   productName: 'Product 9',

&#x20;   category: 'Mouse',

&#x20;   brand: 'Dell',

&#x20;   price: 5500,

&#x20;   stock: 19,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1009, sellerName: 'Seller 9' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.880Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1178c9f666ca04175b'),

&#x20;   productId: 10,

&#x20;   productName: 'Product 10',

&#x20;   category: 'Laptop',

&#x20;   brand: 'Samsung',

&#x20;   price: 6000,

&#x20;   stock: 20,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1010, sellerName: 'Seller 10' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:09.974Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca04175c'),

&#x20;   productId: 11,

&#x20;   productName: 'Product 11',

&#x20;   category: 'Mobile',

&#x20;   brand: 'HP',

&#x20;   price: 6500,

&#x20;   stock: 21,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1011, sellerName: 'Seller 11' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.105Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca04175e'),

&#x20;   productId: 13,

&#x20;   productName: 'Product 13',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'Samsung',

&#x20;   price: 7500,

&#x20;   stock: 23,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1013, sellerName: 'Seller 13' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.305Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca04175f'),

&#x20;   productId: 14,

&#x20;   productName: 'Product 14',

&#x20;   category: 'Mouse',

&#x20;   brand: 'HP',

&#x20;   price: 8000,

&#x20;   stock: 24,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1014, sellerName: 'Seller 14' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.417Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca041760'),

&#x20;   productId: 15,

&#x20;   productName: 'Product 15',

&#x20;   category: 'Laptop',

&#x20;   brand: 'Dell',

&#x20;   price: 8500,

&#x20;   stock: 25,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1015, sellerName: 'Seller 15' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.525Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca041762'),

&#x20;   productId: 17,

&#x20;   productName: 'Product 17',

&#x20;   category: 'Headphones',

&#x20;   brand: 'HP',

&#x20;   price: 9500,

&#x20;   stock: 27,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1017, sellerName: 'Seller 17' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.698Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca041763'),

&#x20;   productId: 18,

&#x20;   productName: 'Product 18',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'Dell',

&#x20;   price: 10000,

&#x20;   stock: 28,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1018, sellerName: 'Seller 18' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.823Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1278c9f666ca041764'),

&#x20;   productId: 19,

&#x20;   productName: 'Product 19',

&#x20;   category: 'Mouse',

&#x20;   brand: 'Samsung',

&#x20;   price: 10500,

&#x20;   stock: 29,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1019, sellerName: 'Seller 19' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:10.898Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041766'),

&#x20;   productId: 21,

&#x20;   productName: 'Product 21',

&#x20;   category: 'Mobile',

&#x20;   brand: 'Dell',

&#x20;   price: 11500,

&#x20;   stock: 31,

&#x20;   rating: 3,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1021, sellerName: 'Seller 21' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.045Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041767'),

&#x20;   productId: 22,

&#x20;   productName: 'Product 22',

&#x20;   category: 'Headphones',

&#x20;   brand: 'Samsung',

&#x20;   price: 12000,

&#x20;   stock: 32,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1022, sellerName: 'Seller 22' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.140Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca041768'),

&#x20;   productId: 23,

&#x20;   productName: 'Product 23',

&#x20;   category: 'Keyboard',

&#x20;   brand: 'HP',

&#x20;   price: 12500,

&#x20;   stock: 33,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1023, sellerName: 'Seller 23' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.248Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176a'),

&#x20;   productId: 25,

&#x20;   productName: 'Product 25',

&#x20;   category: 'Laptop',

&#x20;   brand: 'Samsung',

&#x20;   price: 13500,

&#x20;   stock: 35,

&#x20;   rating: 3.5,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'new' ],

&#x20;   seller: { sellerId: 1025, sellerName: 'Seller 25' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.482Z')

&#x20; },

&#x20; {

&#x20;   \_id: ObjectId('6aa0dd1378c9f666ca04176b'),

&#x20;   productId: 26,

&#x20;   productName: 'Product 26',

&#x20;   category: 'Mobile',

&#x20;   brand: 'HP',

&#x20;   price: 14000,

&#x20;   stock: 36,

&#x20;   rating: 4,

&#x20;   inStock: true,

&#x20;   tags: \[ 'electronics', 'featured' ],

&#x20;   seller: { sellerId: 1026, sellerName: 'Seller 26' },

&#x20;   createdAt: ISODate('2026-09-09T04:14:11.559Z')

&#x20; }

]

Type "it" for more

Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> db.products.find({

&#x20;  stockQuantity: { $gt: 0 }

&#x20;})



\-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-



Atlas atlas-wfq7gu-shard-0 \[primary] ecomDB> const categories = \[

&#x20;   "Electronics",

&#x20;   "Mobiles",

&#x20;   "Laptops",

&#x20;   "Home Appliances",

&#x20;   "Fashion",

&#x20;   "Books",

&#x20;   "Sports",

&#x20;   "Beauty",

&#x20;   "Grocery",

&#x20;   "Furniture"

];



const subCategories = {

&#x20;   "Electronics": \["Headphones", "Smartwatch", "Camera", "Speaker"],

&#x20;   "Mobiles": \["Android", "iPhone", "Feature Phone"],

&#x20;   "Laptops": \["Gaming", "Business", "Student"],

&#x20;   "Home Appliances": \["Refrigerator", "Washing Machine", "Microwave"],

&#x20;   "Fashion": \["Men", "Women", "Kids"],

&#x20;   "Books": \["Programming", "Fiction", "Education"],

&#x20;   "Sports": \["Cricket", "Football", "Fitness"],

&#x20;   "Beauty": \["Skincare", "Haircare", "Makeup"],

&#x20;   "Grocery": \["Snacks", "Beverages", "Staples"],

&#x20;   "Furniture": \["Chair", "Table", "Sofa"]

};



const brands = \[

&#x20;   "Samsung",

&#x20;   "Apple",

&#x20;   "Sony",

&#x20;   "LG",

&#x20;   "HP",

&#x20;   "Dell",

&#x20;   "Lenovo",

&#x20;   "Nike",

&#x20;   "Adidas",

&#x20;   "Boat",

&#x20;   "OnePlus",

&#x20;   "AmazonBasics"

];



const cities = \[

&#x20;   "Chennai",

&#x20;   "Coimbatore",

&#x20;   "Bangalore",

&#x20;   "Hyderabad",

&#x20;   "Mumbai",

&#x20;   "Delhi",

&#x20;   "Pune",

&#x20;   "Kochi",

&#x20;   "Kolkata",

&#x20;   "Ahmedabad"

];



const states = \[

&#x20;   "Tamil Nadu",

&#x20;   "Karnataka",

&#x20;   "Telangana",

&#x20;   "Maharashtra",

&#x20;   "Delhi",

&#x20;   "Kerala",

&#x20;   "West Bengal",

&#x20;   "Gujarat"

];



const paymentMethods = \[

&#x20;   "UPI",

&#x20;   "Credit Card",

&#x20;   "Debit Card",

&#x20;   "Net Banking",

&#x20;   "Cash on Delivery"

];



const orderStatuses = \[

&#x20;   "Delivered",

&#x20;   "Shipped",

&#x20;   "Processing",

&#x20;   "Cancelled",

&#x20;   "Returned"

];



const sellers = \[

&#x20;   "RetailHub",

&#x20;   "TechWorld",

&#x20;   "MegaStore",

&#x20;   "DigitalMart",

&#x20;   "SmartShop",

&#x20;   "PrimeRetail"

];



const tags = \[

&#x20;   "new",

&#x20;   "popular",

&#x20;   "trending",

&#x20;   "premium",

&#x20;   "budget",

&#x20;   "best-seller",

&#x20;   "discount",

&#x20;   "limited-stock"

];







let documents = \[];







for (let i = 1; i <= 5000; i++) {



&#x20;   const category =

&#x20;       categories\[Math.floor(Math.random() \* categories.length)];



&#x20;   const subCategory =

&#x20;       subCategories\[category]\[

&#x20;           Math.floor(Math.random() \* subCategories\[category].length)

&#x20;       ];



&#x20;   const brand =

&#x20;       brands\[Math.floor(Math.random() \* brands.length)];



&#x20;   const city =

&#x20;       cities\[Math.floor(Math.random() \* cities.length)];



&#x20;   const state =

&#x20;       states\[Math.floor(Math.random() \* states.length)];



&#x20;   const paymentMethod =

&#x20;       paymentMethods\[

&#x20;           Math.floor(Math.random() \* paymentMethods.length)

&#x20;       ];



&#x20;   const orderStatus =

&#x20;       orderStatuses\[

&#x20;           Math.floor(Math.random() \* orderStatuses.length)

&#x20;       ];



&#x20;   const seller =

&#x20;       sellers\[

&#x20;           Math.floor(Math.random() \* sellers.length)

&#x20;       ];





&#x20;   const quantity =

&#x20;       Math.floor(Math.random() \* 5) + 1;



&#x20;   const price =

&#x20;       Math.floor(Math.random() \* 95000) + 500;



&#x20;   const discount =

&#x20;       Math.floor(Math.random() \* 51);



&#x20;   const discountedPrice =

&#x20;       Math.round(

&#x20;           price - (price \* discount / 100)

&#x20;       );



&#x20;   const rating =

&#x20;       Number(

&#x20;           (Math.random() \* 4 + 1).toFixed(1)

&#x20;       );



&#x20;   const stock =

&#x20;       Math.floor(Math.random() \* 500);





&#x20;

&#x20;   const selectedTags = \[];



&#x20;   for (let j = 0; j < 2; j++) {



&#x20;       selectedTags.push(

&#x20;           tags\[Math.floor(Math.random() \* tags.length)]

&#x20;       );

&#x20;   }





&#x20;

&#x20;   const startDate =

&#x20;       new Date("2024-01-01").getTime();



&#x20;   const endDate =

&#x20;       new Date("2026-08-25").getTime();



&#x20;   const randomDate =

&#x20;       new Date(

&#x20;           startDate +

&#x20;           Math.random() \* (endDate - startDate)

&#x20;       );





&#x20;

&#x20;   const product = {



&#x20;       productId:

&#x20;           "PROD" + String(i).padStart(5, "0"),



&#x20;       productName:

&#x20;           brand + " " + subCategory + " " + i,



&#x20;       category: category,



&#x20;       subCategory: subCategory,



&#x20;       brand: brand,



&#x20;       price: price,



&#x20;       discountPercentage: discount,



&#x20;       discountedPrice: discountedPrice,



&#x20;       quantity: quantity,



&#x20;       revenue:

&#x20;           discountedPrice \* quantity,



&#x20;       rating: rating,



&#x20;       reviewCount:

&#x20;           Math.floor(Math.random() \* 5000),



&#x20;       stock: stock,



&#x20;       inStock:

&#x20;           stock > 0,





&#x20;       seller: {



&#x20;           name: seller,



&#x20;           sellerRating:

&#x20;               Number(

&#x20;                   (Math.random() \* 4 + 1).toFixed(1)

&#x20;               )

&#x20;       },





&#x20;       customer: {



&#x20;           customerId:

&#x20;               "CUS" +

&#x20;               String(

&#x20;                   Math.floor(Math.random() \* 1000) + 1

&#x20;               ).padStart(4, "0"),



&#x20;           city: city,



&#x20;           state: state,



&#x20;           age:

&#x20;               Math.floor(Math.random() \* 50) + 18

&#x20;       },





&#x20;       payment: {



&#x20;           method: paymentMethod,



&#x20;           transactionId:

&#x20;               "TXN" +

&#x20;               Math.random()

&#x20;                   .toString(36)

&#x20;                   .substring(2, 12)

&#x20;       },





&#x20;       orderStatus: orderStatus,



&#x20;       orderDate: randomDate,



&#x20;       tags: selectedTags,





&#x20;       specifications: {



&#x20;           warranty:

&#x20;               (Math.floor(Math.random() \* 3) + 1) +

&#x20;               " years",



&#x20;           color: \[

&#x20;               "Black",

&#x20;               "White",

&#x20;               "Blue",

&#x20;               "Red",

&#x20;               "Silver"

&#x20;           ]\[Math.floor(Math.random() \* 5)],



&#x20;           weight:

&#x20;               Number(

&#x20;                   (Math.random() \* 5 + 0.5).toFixed(2)

&#x20;               )

&#x20;       },





&#x20;       isFeatured:

&#x20;           Math.random() > 0.7,



&#x20;       createdAt: new Date()

&#x20;   };





&#x20;   documents.push(product);





&#x20;

&#x20;   if (documents.length === 500) {



&#x20;       db.aggex.insertMany(documents);



&#x20;       documents = \[];

&#x20;   }

}





if (documents.length > 0) {



&#x20;   db.aggex.insertMany(documents);

}

print("5000 documents inserted successfully into aggex!");







