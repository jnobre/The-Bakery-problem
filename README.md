# The Bakery problem

The bakery uses the item's individual price to generate its orders. Therefore, if a customer ordered 10 pasteis de nata, he would be charged 10 x the cost of a single pastel de nata. The bakery decided to start selling its prepackaged products in packages, charging its customers for packaging. So if the bakery sells the pre-packaged custard tarts in packs of 3 and 5, if a customer orders 8 custard tarts, they would receive a pack of 3 and a pack of 5.
Given an order from a customer I have to return the number of packages that are necessary to satisfy the customer's order, minimizing the number of packages.

The products are as follows:

| Code | Product | Packs (price) | 
|---|---|---|
| PN | Pastel de Nata | 3 @ €6.99 <br> 5 @ €8.99  |
| TS | Travesseiros de Sintra | 2 @ €9.95 <br> 5 @ €16.95 <br> 8 @ €24.95  |
| QJD |  Queijadinha | 3 @ €5.95 <br> 5 @ €9.95 <br> 9 @ €16.99 |

Problem:

Given a customer's order you need to determine the cost and detail of each product. To save space, each order must contain the minimum number of packages.

Input:

Each order consists of lines. Containing the number of items and the product code. Ex:

    10 PN 
    14 TS
    13 QJD

Output:

    10 PN €17.98
        2 x 5 €8.99 
     14 TS €54.8
        1 x 8 €24.95 
        3 x 2 €9.95
    13 QJD €25.85
        2 x 5 €9.95 
        1 x 3 €5.95
