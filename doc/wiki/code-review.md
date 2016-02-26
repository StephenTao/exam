# Code Review Summary

----------

## SP01

### Eric Liu
1. If the name of class is abbreviation, it should be uppercase. If not, its first letter should be uppercase.
2. SQL statement should be writen with correct format. If the length of one SQL larger than common, don't foget to begin on a new line.
3. Column name shoudn't be named key words when creating database tables. otherwise, it is going wrong when you operate DB in DAO layer.
4. You must know how to named a class. It's necessary for you to named one class that someone could understantd your meaning.
5. When you create a class according to one DB table whose name begin with map, the name of class should not begin with map words.
6. Using elementary data type instead of wrapper type when define fields in one class.
7. Pay attention to NullException when quote one parameter.
8. Delete 'is' at the begin of fields when named fields in one class If fields are begin with 'is' in a mapping DB table.

### Stephen Huang


### Zander Li
1. Using different HTTP request method(post, get, put, delete) in CRUD
2. There should be a data validation on add and update method
3. An object needs to be judged whether it is empty before using it
4. The CRUD method names in DAO need to be the same as the SQL ID in mapper file
5. There should be newline if the SQL statement in mapper file is too long
6. A field similar to the creation time requires the use of the database for the current time method(like: NOW())
7. Please pay attention to avoid loss of data when the type of object forced conversion
8. Using class's getName method to get class's path
9. SQL constant needs to add SQLID prefix
10. Relational tables do not require Controller and Service class
11. File uses of UNIX newline
12. The get method of the boolean type is beginning of 'is'

------------------------