USE db;
-- 1
SELECT COUNT(*) FROM (SELECT userID FROM sellerrating UNION SELECT userID FROM buyerrating) e;
-- 2
SELECT COUNT(*) FROM items JOIN locations ON items.sellerID = locations.userID WHERE BINARY locations.location = 'New York';
-- 3
SELECT COUNT(itemID) FROM (SELECT itemID FROM categories GROUP BY itemID HAVING COUNT(category) = 4) e;
-- 4
SELECT bids.itemID, amount FROM bids JOIN items ON bids.itemID = items.itemID WHERE ends > '2001-12-20 00:00:01' AND bids.amount = (SELECT amount FROM bids ORDER BY amount DESC LIMIT 1);
-- 4 alt 1: this query selects the highest bid for each item if it exists, 0.0 if there is no bid.
-- SELECT items.itemID, currentBid FROM items JOIN bids on items.itemID = bids.itemID WHERE ends > '2001-12-20 00:00:01' UNION (SELECT itemID, 0.0 FROM items WHERE itemID NOT IN (SELECT itemID FROM bids));
-- 5
SELECT COUNT(*) FROM sellerrating WHERE srating > 1000;
-- 6
SELECT COUNT(*) FROM sellerrating JOIN buyerrating ON sellerrating.userID = buyerrating.userID;
-- 7
SELECT COUNT(DISTINCT(category)) FROM categories JOIN bids ON categories.itemID = bids.itemID WHERE amount > 100;