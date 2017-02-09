'use strict';

describe('BeerApp', function() {


  it('should automatically redirect to /view1 when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("/view");
  });


  describe('view', function() {

    beforeEach(function() {
      browser.get('index.html#!/view');
    });


    it('should render view when user navigates to /view', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for view /);
    });

  });
});
