
# Tasks
## Collections

### Part 1

> ### Task 1
> #### ***Description:***
> 
>   There is the chats list.
>   Each chat has two fields: `name` and `number of users`.
> 
>>   ***Task:***
>>
>> - Use an iterator to remove all chats that contain less than 1000 users.
>> 
>> - Sort the rest of chats by the number of users in descending order using comparators. If the number of users are equal than sort chats by name in alphabetical order.
>>
>> - Also provide sorting by name as default.

> ### Task 2
> #### ***Description:***
>
>   There is the chats list from previous task. 
>   Use the list of `User` objects that contains 3 fields: `id` (int), `name` and `age` instead of `number of users` field 
>   
>
>>   ***Task:***
>>
>> - Convert chats list to list of chats users whose age is more than 18 age.
>>
>> - Use an iterator to calculate the average age of all remaining users.


### Part 2

> ### Task 1
> #### ***Description:***
>
>   There is 2 classes.
>   - `Movie` class. It contains 5 fields:
>       - id (int)
>       - release year
>       - release month
>       - genre
>       - rating
>   - `Cinema` class. It contains only 1 field - a sorted associative array where the `key` is release year and the `value` is all films released in that year.
>
>>   ***Task:***
>>
>> - Add next functionality to the cinema provide possibility to:
>>   - add new movie
>>   - get all movies by given year
>>   - get all movies by given year and month
>>   - get all movies by given genre
>>   - get TOP 10 films sorted by rating in descending order
>>
>> 
>>   *Please, pay attention to:*
>>  - all films should be stored in the cinema in the order they were added to it (i.e. provide the order of the value of the associative array)
>>  - a film should not be added if there is already one in the cinema
>> 
>>
>> Demonstrate the cinema work in a separate class.