# GitHub API Handler

 The service where the user can enter any word and get the list of PHP and JavaScript repositories from GitHub where the entered word is mentioned in the name. Each repository in the list contains name, link to repository on GitHub and some information about repository owner.
 
Used technologies:
  - Spring MVC, Spring boot
  - Jackson

To run you need to import project:
- First of all clone repository or download it as zip
- If you downloaded project as zip then extract it to any directory
- Go to your IDE
- If you use Intellij Idea go File/Open.. then find directory with the project, click "pom.xml" and then click "Ok"
- Profit!

Pretty sure another IDEs have similar interface to do that.

Known issues:
- Paging, github API returns response repositories with 60 count for page
- Can't get exactly number of pages, if you tring to calculate it as (total_count/60) and tring to iterate through pages than you getting "Server returned HTTP response code: 403 for URL" in some page because of request rate limit of Github API, even with auth token.
- Rate limit, github API has requests limit per hour
