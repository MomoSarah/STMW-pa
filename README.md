1.
table itemdata (itemID primary key, name, sellerID, firstBid, currentBi, started, ends, description) 
-- number of bids is removed because the bids table enables its derivation. As there can be no bids, it would also be able to calculate the current bid from it, but this is a little more challenging. It was kept there.
table bids (itemID , bidderID , amount , bidtime) primary key (itemID, amount) 
--amount was selected as the primary key component since it is conceivable that no two bids on the same item will be the same.
table categories (itemID, category) primary key (itemID, category)
table buyprice (itemID primary key, price)
table locations (userID primary key, location)
table countries (userID primary key, country) 
-- it appears at first glance that every user has a location and a country, but not necessarily buyers. as an example, see CALVIN at line 12298 in items-0.xml
table sellerrating (userID primary key, sellerrating) 
-- users' seller rating and buyer ratings are kept in different tables since they may both be null if they only exist in one category.
table buyerrating (userID  primary key, buyerrating)
table userlatlong (userID primary key, latitude, longitude)

2.
In the table itemdata, all non-key attributes are functionally dependent on the itemID, as this ID specifies the listed item that has these attributes.
(itemID -> name, sellerID, firstBid currentBid, started, ends, description)
For the table bids, there can be only one bid on one item for a certain amount. As such, the other attributes can be derived from itemID and amount. Presumably, a user can also make one bid at a specific datetime, but this could be circumvented using automated bidding, so this is not as certain.
(itemID, amount -> bidderID, bidtime)
There are no functional dependencies in the table categories. An item can have multiple categories and vice versa.

The optional buying price of an item is again dependent on the itemID.
(itemID -> price)
A user's location and country in the respective tables are functionally dependent on the userID. Locations seem to be freely entered by the user rather than referring to specific places in the world, so they cannot specify a country (e.g. the location 'Bremen' could refer to Bremen, Germany, or one of several places called Bremen in the USA).
(userID -> {location,country})
In the sellerrating and buyerrating tables, the ratings are functionally dependent on the userID.
(userID -> {seller,buyer}rating)
The optional latitude and longitude are also dependent on the specific user. They can also be different for the same location.
(userID -> latitude, longitude)

3.
All relations apart from bids only include functional dependencies where non-prime attributes are dependent on the primary key. They are thus in BCNF.
In the table bids, the story is a bit more complicated. If, as speculated, a user cannot place more than one bid at the same exact datetime, then (bidderID, bidtime) would also form a candidate key. I would argue, however, that there could (in a 'infinite monkeys on infinite typewriters' approach) be multiple bids with the same user and datetime in the system, but none with the same itemID and amount. Regardless, we can not conceive of a decomposition of this table that would offer a tangible benefit.

4.
There are no additional multivalued dependencies on top of the functional dependencies already listed. Thus, by the same argument as above, the relations are in 4NF.
