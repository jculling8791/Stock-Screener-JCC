# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice-looking HTML.

## Part 1.1: App Description

> This is a stock screener app. The app, when ran, will give the user
> the 20 stocks that had the highest traded volume on the day. This list
> updates every 15 minutes. There is an API limit of 25 per day, which is
> shown on the first window. Each of the 20 stocks will also have their
> current price, their change in price, and their volume. They are sorted
> by volume. The user is able to click on any of the 20 symbols and each will
> take them to their own unique window. The subsequent window displays two forecasted
> financial statements, the income statement and the balance sheet, then to the right
> the user will see a forecasted Free Cash Flow and Econcomic Value Added chart.
> The user can click on a button labelled "Assumptions" to see how the valuations are
> structured. The assumptions are calculated from taking historical averages of the ratios from
> previous year line items. They are all unique to each ticker,
> except for tax rate, Terminal sales growth, and CAPM units. The user needs to
> only fill in one thing within each stock's subsequent window, and that is
> sales growth projections for the next 5 years. After that, the Balance Sheet
> and Income Statements are forecasted and the valuations are complete. The program
> will give the user a recommendation to the ticker based on the valuation results.
> Four APIs are used. One to pull historical data for a given ticker's balance sheet,
> one for the income statement, one to pull the company NAME of the ticker, and one
> to give the 20 most actively traded stocks on the day. The program initially displays
> the 20 most actively traded, the user clicks on one of them and in the next window we
> see the respective company name. The Assumptions are all derived from the GIVEN company's
> financial statements, so on and so forth. All four APIs are used and very much connected.
> Simply put, the 20 stocks that TOPGAINERSLOSERS returns, are then used to call the
> balance sheet, the income statement, and the current price for whichever of the 20
> stocks that the user selects.

> https://github.com/jculling8791/cs1302-api-app (hopefully it is private)

> Currently, the app is using a mock data set to populate the second window. Reason being
> is that my apikey has hit the rate limit. You can find the line to SWITCH from a mock data
> set to a real query in ApiService.java at line 21. You will find the following JSON response:
> Raw income statement JSON response: {
>     "Information": "Thank you for using Alpha Vantage! Our standard API rate limit is 25 requests per day. Please subscribe to any of the premium plans at https://www.alphavantage.co/premium/ to instantly remove all daily rate limits."
> }
> Raw balance sheet JSON response: {
>    "Information": "Thank you for using Alpha Vantage! Our standard API rate limit is 25 requests per day. Please subscribe to any of the premium plans at https://www.alhp> avantage.co/premium/ to instantly remove all daily rate limits."
> }
> Upon inspecting the ApiService class, it should still be apparent that the second and third API queries are dependent on what the user clicks on the first window.


## Part 1.2: APIs


### API 1 (Rate limit of 25 / day)

```
https://www.alphavantage.co/query?function=INCOME_STATEMENT&symbol=MO&apikey=CQ3874PRX46CHQYR
```


### API 2 (Rate limit of 25 / day)

```
https://www.alphavantage.co/query?function=BALANCE_SHEET&symbol=MO&apikey=CQ3874PRX46CHQYR
```

### API 3 (Rate limit of 25 / day)

...
https://www.alphavantage.co/query?function=TOP_GAINERS_LOSERS&apikey=CQ3874PRX46CHQYR
...


### API 4 (Rate limit of 100)

...
https://api.stockdata.org/v1/data/quote?symbols=MO&extended_hours=true&api_token=TUsCclPdicKerPrDXzGnpEF7qGvKJBsnLnQZosES
...

## Part 2: New

> What is something new and/or exciting that you learned from working
> on this project?

Honestly, a project like this is exactly what I needed. When I first
thought about doing computer science, and how I thought I had skills
to offer, I pictured doing a project like this, but even if you had asked me 2 months
ago, I would not have thought I would be even remotely close to being able to
complete this on my own. I learned what I can do with the proper motivation
and time. I learned even more how to properly use API documentation. I learned
how to navigate through the Java API. Most of these free APIs really are simple
when you narrow it down. It all comes down to how creative of a programmer I can be.
And while this may not be the most creative project to be turned in, I see it as something
practical. Not just a project idea for the sake of me turning in, but rather something, that
if I can perfect all the details, that I would use in my daily life.

## Part 3: Retrospect

> If you could start the project over from scratch, what do
> you think might do differently and why?

I would have (and I definitely should have) designed my app on paper
before I started coding. When I began, I had a very rough idea about what
I wanted. Little did I know, that when I started, I would keep
thinking of even better ideas. This resulted in me constantly
having to go back and adding bits of functionality here and
there instead of building it from the ground up in one failed swoop.
Even writing this, there are parts of the project that I am not happy with.
But honestly, the things that I wish I could change, seem too difficult
to be able to do quickly and effectively. I'm sure that if I had sat down
at the start and mapped it all out, that I would not be sitting here with the same issue.
