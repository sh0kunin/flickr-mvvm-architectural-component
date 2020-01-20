# flickr-mvvm-architectural-component
Flickr android app using android architectural components and follows mvvm.
The app supports the basic feature of searching for images and displaying on the view which supports endless scrolling, where prefetch request is made with 3/4 the elements scrolled.


## Architecture : 
This app is an example to demonstrate MVVM architecture, while making use of LiveData, Room and Paging android architectural components.
The app also follows the principles from clean architecture, without separating out different modules, but ensuring SOLID principles.

![App Architecture](https://github.com/sh0kunin/flickr-mvvm-architectural-component/blob/master/architecture/final-architecture.png)

# Features : 
1. Search Image using Flickr API. 
2. Endless scrolling.
3. Manual network request setup.
4. Manual dependency injection.

# Flow of the Application : 
1. Room to create the database.
2. Live Data for observing the data changes.
3. Repository gets the data either from API or local database.
4. ViewModelFactory creates a ViewModel for us.
4. ViewModel will help us provide data between repository and UI.
5. RecyclerView displays the 3-layered grid view.

# General Android design considerations :
1. Memory : 
    - Executors and Async Tasks will ensure background thread to downlaod images.
    - Database reads are on background thread.
    - Using LiveData and ensuring viewmodel doesn't leak memory.
    
2. Battery : 
    - Network calls are controlled and catered too.
3. Bandwith : 
    - The app is light weight, but basic design ensured, network calls are made only in the app and cancel and potential tasks/
4. Resilience : 
    - Offline support and caching is not yet provided.
5. Persistence : 
    - Have used RoomDB, which persists the previous searches.
6. Scalability : 
    - Since no 3rd party library is used, neither the google play services, the app can scale to different play stores(including china, with most restrictions)
 
# High-Level Design :

Once the network call is fired to get images, those are first inserted in the database(using room) and then LiveData provided them to the views.
 
1. Model
    - ImageEntity - Single source of truth.
2. View 
    - Search
        - SearchActivity 
        - SearchFragment
            -  RecyclerView - 3 layer grid setup, with SpaceDecorator.
            - Square Image layout 
3. View Model
    - Search
        - SearchViewModel
4. Repository
    - Local [Room]  
    - Remote [Manual HTTP, Async Task]
        - Network
        
5. Room
    - ImageEntity
        - Representation of Image table. 
    - ImageDAO 
        - Interface to get SQL queries for images and inserting images.
    - Database
 

# Low-Level Design : 
1. WebServices
    - This class is responsible for making the network calls
2. SearchImageRepository
    - Local data source: Room
    - Remote: WebService, makes the network call and gets the images.
    - Making use of LiveData here to do the following :
        - One way communication with the ViewModel, ensuring clean architecture.
        - A single source of truth for data and network statuses(success, loading or error). 
3. Endless scrolling: Using SearchBoundaryCallback, once the prefetch distance is reached(3/4 the elements are scrolled), it asks repository to get more data, which in turn makes a network call to get more data. Keeping the SOLID intact.
4. ViewModel 
    - ViewModel factory pattern is used to deliver the ViewModel, so the creation is unknown to the caller. Reserving SOLID.
    - As the user types the query and hit the search button, ViewModel ensures to search the images.
    - Since the repository exposed a single live data object, mapping to display data and UI states are handled here.

# Unit Tests : 
    - Testing made easy with dependencies mocked.
    - Minimum test coverage currently, just to show testing of different services.

# Special Mention :
    - Live Data
        - Ensuring no memory leaks and crashes due to activity lifecycle.
        - Up to date data : The data and UI are always in sync, a single live data object used ensures, all UI states and data lept in sync.
        - Support configuration changes.   

![Live Data](https://github.com/sh0kunin/flickr-mvvm-architectural-component/blob/master/architecture/LiveData.gif)
 
 
# Architectural Improvements : 
    - Follow clean architecture - Seperate out different modules. 
    - Possible replacement of LiveData in Repository with Rx(https://proandroiddev.com/the-real-repository-pattern-in-android-efba8662b754)
 
# Feature Improvements :
    - Cross icon in search box.
    - Network error messages.
    - Scale down the images.
    - Better image aspect ratio url selection.
    - Default Search.
    - Lots of design changes, its just dummy UI, no way close to design guidelines.
    - This list can never end.    

# Testing Improvements : 
    - Improve code coverage for unit tests, current coverage is time boxed, just a demo to show unit testing possibilities.
    - Add end-to-end espresso tests.