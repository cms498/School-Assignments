# Future Plan

## Popularity Tears

### What would I need to change

The biggest thing i would have to change would come in the schema for the books table, I would add another column
to represent the popularity tear of the book ranked on a scale from 1 - 5 (least to most popular). During the checkout
process I would have to look at the popularity tear and then calculate the due date from there. I would also need to change the late fees calculation to take the tear into account, as currently I have the fees amount hardcoded on 7 days

### What API methods would I provide

I wouldn't provided any more API methods

### What API methods would change

1. check_out_book()
2. calculate_late_fee(book_id, username)

## Overdue Warnings

### What tables need changing and/or adding

I would need to add a table for all of the overdue warnings sent, my user table already has the users phone number and email, so none of these would need changing. 

### What API methods would I provide

I would create an API method to send a user an email. There is a python module called SMTP which can be used to send emails. I would create an API to get the current date, that way we can tell if the due date has passed and by how many days

### How might existing API methods change

No other methods would need to get changed, as the functionality of this method is dependent on any others, we would just need to make sure that the checkout function is properly generating the due date. 

### What extra workflow logic would I need

In checkout, I would have to check to see if they have any books that are late using the current date, I then would send out the message if they are more then a week late, the work flow after for disabling their account wouldn't change. The librarian at any point could also just call this method and send out mass messages to all users if they are overdue 