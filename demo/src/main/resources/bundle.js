require=(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
    (function (process){
        'use strict';

        var React = require('react');
        var StylePropable = require('./mixins/style-propable');
        var Typography = require('./styles/typography');
        var IconButton = require('./icon-button');
        var NavigationMenu = require('./svg-icons/navigation-menu');
        var Paper = require('./paper');

        var AppBar = React.createClass({
            displayName: 'AppBar',

            mixins: [StylePropable],

            contextTypes: {
                muiTheme: React.PropTypes.object
            },

            propTypes: {
                onLeftIconButtonTouchTap: React.PropTypes.func,
                onRightIconButtonTouchTap: React.PropTypes.func,
                showMenuIconButton: React.PropTypes.bool,
                iconClassNameLeft: React.PropTypes.string,
                iconClassNameRight: React.PropTypes.string,
                iconElementLeft: React.PropTypes.element,
                iconElementRight: React.PropTypes.element,
                iconStyleRight: React.PropTypes.object,
                title: React.PropTypes.node,
                zDepth: React.PropTypes.number },

            getDefaultProps: function getDefaultProps() {
                return {
                    showMenuIconButton: true,
                    title: '',
                    zDepth: 1
                };
            },

            componentDidMount: function componentDidMount() {
                if (process.env.NODE_ENV !== 'production' && (this.props.iconElementLeft && this.props.iconClassNameLeft)) {
                    var warning = 'Properties iconClassNameLeft and iconElementLeft cannot be simultaneously ' + 'defined. Please use one or the other.';
                    console.warn(warning);
                }
            },

            getStyles: function getStyles() {
                var spacing = this.context.muiTheme.spacing;
                var themeVariables = this.context.muiTheme.component.appBar;
                var iconButtonSize = this.context.muiTheme.component.button.iconButtonSize;
                var styles = {
                    root: {
                        zIndex: 5,
                        width: '100%',
                        minHeight: themeVariables.height,
                        backgroundColor: themeVariables.color,
                        paddingLeft: spacing.desktopGutter,
                        paddingRight: spacing.desktopGutter
                    },
                    title: {
                        float: 'left',
                        margin: 0,
                        paddingTop: 0,
                        letterSpacing: 0,
                        fontSize: 24,
                        fontWeight: Typography.fontWeightNormal,
                        color: themeVariables.textColor,
                        lineHeight: themeVariables.height + 'px'
                    },
                    iconButton: {
                        style: {
                            marginTop: (themeVariables.height - iconButtonSize) / 2,
                            float: 'left',
                            marginRight: 8,
                            marginLeft: -16
                        },
                        iconStyle: {
                            fill: themeVariables.textColor,
                            color: themeVariables.textColor
                        }
                    }
                };
                return styles;
            },

            render: function render() {
                var styles = this.getStyles();

                var title;
                var menuElementLeft;
                var menuElementRight;
                var iconRightStyle = this.mergeAndPrefix(styles.iconButton.style, {
                    float: 'right',
                    marginRight: -16,
                    marginLeft: 8
                }, this.props.iconStyleRight);

                if (this.props.title) {
                    // If the title is a string, wrap in an h1 tag.
                    // If not, just use it as a node.
                    title = Object.prototype.toString.call(this.props.title) === '[object String]' ? React.createElement(
                        'h1',
                        { style: this.mergeAndPrefix(styles.title) },
                        this.props.title
                    ) : this.props.title;
                }

                if (this.props.showMenuIconButton) {
                    if (this.props.iconElementLeft) {
                        menuElementLeft = React.createElement(
                            'div',
                            { style: styles.iconButton.style },
                            this.props.iconElementLeft
                        );
                    } else {
                        var child = this.props.iconClassNameLeft ? '' : React.createElement(NavigationMenu, { style: this.mergeAndPrefix(styles.iconButton.iconStyle) });
                        menuElementLeft = React.createElement(
                            IconButton,
                            {
                                style: this.mergeAndPrefix(styles.iconButton.style),
                                iconStyle: this.mergeAndPrefix(styles.iconButton.iconStyle),
                                iconClassName: this.props.iconClassNameLeft,
                                onTouchTap: this._onLeftIconButtonTouchTap },
                            child
                        );
                    }

                    if (this.props.iconElementRight) {
                        menuElementRight = React.createElement(
                            'div',
                            { style: iconRightStyle },
                            this.props.iconElementRight
                        );
                    } else if (this.props.iconClassNameRight) {
                        menuElementRight = React.createElement(IconButton, {
                            style: iconRightStyle,
                            iconStyle: this.mergeAndPrefix(styles.iconButton.iconStyle),
                            iconClassName: this.props.iconClassNameRight,
                            onTouchTap: this._onRightIconButtonTouchTap });
                    }
                }

                return React.createElement(
                    Paper,
                    {
                        rounded: false,
                        className: this.props.className,
                        style: this.mergeAndPrefix(styles.root, this.props.style),
                        zDepth: this.props.zDepth },
                    menuElementLeft,
                    title,
                    menuElementRight,
                    this.props.children
                );
            },

            _onLeftIconButtonTouchTap: function _onLeftIconButtonTouchTap(event) {
                if (this.props.onLeftIconButtonTouchTap) {
                    this.props.onLeftIconButtonTouchTap(event);
                }
            },

            _onRightIconButtonTouchTap: function _onRightIconButtonTouchTap(event) {
                if (this.props.onRightIconButtonTouchTap) {
                    this.props.onRightIconButtonTouchTap(event);
                }
            }

        });

        module.exports = AppBar;
    }).call(this,require('_process'))
},{"./icon-button":26,"./mixins/style-propable":36,"./paper":40,"./styles/typography":56,"./svg-icons/navigation-menu":63,"_process":103,"react":"react"}],2:[function(require,module,exports){
    'use strict';

    var React = require('react');

    var AppCanvas = React.createClass({
        displayName: 'AppCanvas',

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        render: function render() {

            var styles = {
                height: '100%',
                backgroundColor: this.context.muiTheme.palette.canvasColor,
                WebkitFontSmoothing: 'antialiased'
            };

            var newChildren = React.Children.map(this.props.children, function (currentChild) {
                if (!currentChild) {
                    // If undefined, skip it
                    return;
                }

                switch (currentChild.type.displayName) {
                    case 'AppBar':
                        return React.cloneElement(currentChild, {
                            style: {
                                position: 'fixed' }
                        });
                    default:
                        return currentChild;
                }
            }, this);

            return React.createElement(
                'div',
                { style: styles },
                newChildren
            );
        }

    });

    module.exports = AppCanvas;
},{"react":"react"}],3:[function(require,module,exports){
    'use strict';

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var AutoPrefix = require('./styles/auto-prefix');

    /**
     *  BeforeAfterWrapper
     *    An alternative for the ::before and ::after css pseudo-elements for
     *    components whose styles are defined in javascript instead of css.
     *
     *  Usage: For the element that we want to apply before and after elements to,
     *    wrap its children with BeforeAfterWrapper. For example:
     *
     *                                            <Paper>
     *  <Paper>                                     <div> // See notice
     *    <BeforeAfterWrapper>        renders         <div/> // before element
     *      [children of paper]       ------>         [children of paper]
     *    </BeforeAfterWrapper>                       <div/> // after element
     *  </Paper>                                    </div>
     *                                            </Paper>
     *
     *  Notice: Notice that this div bundles together our elements. If the element
     *    that we want to apply before and after elements is a HTML tag (i.e. a
     *    div, p, or button tag), we can avoid this extra nesting by passing using
     *    the BeforeAfterWrapper in place of said tag like so:
     *
     *  <p>
     *    <BeforeAfterWrapper>   do this instead   <BeforeAfterWrapper elementType='p'>
     *      [children of p]          ------>         [children of p]
     *    </BeforeAfterWrapper>                    </BeforeAfterWrapper>
     *  </p>
     *
     *  BeforeAfterWrapper features spread functionality. This means that we can
     *  pass HTML tag properties directly into the BeforeAfterWrapper tag.
     *
     *  When using BeforeAfterWrapper, ensure that the parent of the beforeElement
     *  and afterElement have a defined style position.
     */

    var BeforeAfterWrapper = React.createClass({
        displayName: 'BeforeAfterWrapper',

        mixins: [StylePropable],

        propTypes: {
            beforeStyle: React.PropTypes.object,
            afterStyle: React.PropTypes.object,
            beforeElementType: React.PropTypes.string,
            afterElementType: React.PropTypes.string,
            elementType: React.PropTypes.string
        },

        getDefaultProps: function getDefaultProps() {
            return {
                beforeElementType: 'div',
                afterElementType: 'div',
                elementType: 'div' };
        },

        render: function render() {
            var _props = this.props;
            var beforeStyle = _props.beforeStyle;
            var afterStyle = _props.afterStyle;
            var beforeElementType = _props.beforeElementType;
            var afterElementType = _props.afterElementType;
            var elementType = _props.elementType;

            var other = _objectWithoutProperties(_props, ['beforeStyle', 'afterStyle', 'beforeElementType', 'afterElementType', 'elementType']);

            var beforeElement, afterElement;

            beforeStyle = AutoPrefix.all({ boxSizing: 'border-box' });
            afterStyle = AutoPrefix.all({ boxSizing: 'border-box' });

            if (this.props.beforeStyle) beforeElement = React.createElement(this.props.beforeElementType, { style: this.mergeAndPrefix(beforeStyle, this.props.beforeStyle),
                key: '::before' });
            if (this.props.afterStyle) afterElement = React.createElement(this.props.afterElementType, { style: this.mergeAndPrefix(afterStyle, this.props.afterStyle),
                key: '::after' });

            var children = [beforeElement, this.props.children, afterElement];

            var props = other;
            props.style = this.props.style;

            return React.createElement(this.props.elementType, props, children);
        }

    });

    module.exports = BeforeAfterWrapper;
},{"./mixins/style-propable":36,"./styles/auto-prefix":49,"react":"react"}],4:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var EnhancedSwitch = require('./enhanced-switch');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var CheckboxOutline = require('./svg-icons/toggle-check-box-outline-blank');
    var CheckboxChecked = require('./svg-icons/toggle-check-box-checked');

    var Checkbox = React.createClass({
        displayName: 'Checkbox',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            iconStyle: React.PropTypes.object,
            onCheck: React.PropTypes.func
        },

        getInitialState: function getInitialState() {
            return {
                switched: this.props.checked || this.props.defaultChecked || this.props.valueLink && this.props.valueLink.value || false };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.checkbox;
        },

        getStyles: function getStyles() {
            var checkboxSize = 24;
            var styles = {
                icon: {
                    height: checkboxSize,
                    width: checkboxSize },
                check: {
                    position: 'absolute',
                    opacity: 0,
                    transform: 'scale(0)',
                    transitionOrigin: '50% 50%',
                    transition: Transitions.easeOut('450ms', 'opacity', '0ms') + ', ' + Transitions.easeOut('0ms', 'transform', '450ms'),
                    fill: this.getTheme().checkedColor
                },
                box: {
                    position: 'absolute',
                    opacity: 1,
                    fill: this.getTheme().boxColor,
                    transition: Transitions.easeOut('2s', null, '200ms')
                },
                checkWhenSwitched: {
                    opacity: 1,
                    transform: 'scale(1)',
                    transition: Transitions.easeOut('0ms', 'opacity', '0ms') + ', ' + Transitions.easeOut('800ms', 'transform', '0ms')
                },
                boxWhenSwitched: {
                    transition: Transitions.easeOut('100ms', null, '0ms'),
                    fill: this.getTheme().checkedColor
                },
                checkWhenDisabled: {
                    fill: this.getTheme().disabledColor
                },
                boxWhenDisabled: {
                    fill: this.getTheme().disabledColor
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var onCheck = _props.onCheck;

            var other = _objectWithoutProperties(_props, ['onCheck']);

            var styles = this.getStyles();
            var boxStyles = this.mergeAndPrefix(styles.box, this.state.switched && styles.boxWhenSwitched, this.props.iconStyle, this.props.disabled && styles.boxWhenDisabled);
            var checkStyles = this.mergeAndPrefix(styles.check, this.state.switched && styles.checkWhenSwitched, this.props.iconStyle, this.props.disabled && styles.checkWhenDisabled);

            var checkboxElement = React.createElement(
                'div',
                null,
                React.createElement(CheckboxOutline, { style: boxStyles }),
                React.createElement(CheckboxChecked, { style: checkStyles })
            );

            var rippleColor = this.state.switched ? checkStyles.fill : boxStyles.fill;

            var enhancedSwitchProps = {
                ref: 'enhancedSwitch',
                inputType: 'checkbox',
                switched: this.state.switched,
                switchElement: checkboxElement,
                rippleColor: rippleColor,
                iconStyle: styles.icon,
                onSwitch: this._handleCheck,
                onParentShouldUpdate: this._handleStateChange,
                defaultSwitched: this.props.defaultChecked,
                labelPosition: this.props.labelPosition ? this.props.labelPosition : 'right'
            };

            return React.createElement(EnhancedSwitch, _extends({}, other, enhancedSwitchProps));
        },

        isChecked: function isChecked() {
            return this.refs.enhancedSwitch.isSwitched();
        },

        setChecked: function setChecked(newCheckedValue) {
            this.refs.enhancedSwitch.setSwitched(newCheckedValue);
        },

        _handleCheck: function _handleCheck(e, isInputChecked) {
            if (this.props.onCheck) this.props.onCheck(e, isInputChecked);
        },

        _handleStateChange: function _handleStateChange(newSwitched) {
            this.setState({ switched: newSwitched });
        }

    });

    module.exports = Checkbox;
},{"./enhanced-switch":21,"./mixins/style-propable":36,"./styles/transitions":55,"./svg-icons/toggle-check-box-checked":64,"./svg-icons/toggle-check-box-outline-blank":65,"react":"react"}],5:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');

    var CircularProgress = React.createClass({
        displayName: 'CircularProgress',

        mixins: [StylePropable],

        propTypes: {
            mode: React.PropTypes.oneOf(['determinate', 'indeterminate']),
            value: React.PropTypes.number,
            min: React.PropTypes.number,
            max: React.PropTypes.number,
            size: React.PropTypes.number
        },

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        _getRelativeValue: function _getRelativeValue() {
            var value = this.props.value;
            var min = this.props.min;
            var max = this.props.max;

            var clampedValue = Math.min(Math.max(min, value), max);
            var rangeValue = max - min;
            var relValue = Math.round(clampedValue / rangeValue * 10000) / 10000;
            return relValue * 100;
        },

        componentDidMount: function componentDidMount() {

            var wrapper = React.findDOMNode(this.refs.wrapper);
            var path = React.findDOMNode(this.refs.path);

            this._scalePath(path);
            this._rotateWrapper(wrapper);
        },
        _scalePath: function _scalePath(path, step) {
            step = step || 0;
            step %= 3;

            setTimeout(this._scalePath.bind(this, path, step + 1), step ? 750 : 250);

            if (!this.isMounted()) return;
            if (this.props.mode != 'indeterminate') return;

            if (step === 0) {

                path.style.strokeDasharray = '1, 200';
                path.style.strokeDashoffset = 0;
                path.style.transitionDuration = '0ms';
            } else if (step == 1) {

                path.style.strokeDasharray = '89, 200';
                path.style.strokeDashoffset = -35;
                path.style.transitionDuration = '750ms';
            } else {

                path.style.strokeDasharray = '89,200';
                path.style.strokeDashoffset = -124;
                path.style.transitionDuration = '850ms';
            }
        },
        _rotateWrapper: function _rotateWrapper(wrapper) {

            setTimeout(this._rotateWrapper.bind(this, wrapper), 10050);

            if (!this.isMounted()) return;
            if (this.props.mode != 'indeterminate') return;

            wrapper.style.transform = null;
            wrapper.style.transform = 'rotate(0deg)';
            wrapper.style.transitionDuration = '0ms';

            setTimeout(function () {
                wrapper.style.transform = 'rotate(1800deg)';
                wrapper.style.transitionDuration = '10s';
            }, 50);
        },

        getDefaultProps: function getDefaultProps() {
            return {
                mode: 'indeterminate',
                value: 0,
                min: 0,
                max: 100,
                size: 1
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.palette;
        },

        getStyles: function getStyles(zoom) {
            zoom *= 1.4;
            var size = '50px';

            var margin = Math.round((50 * zoom - 50) / 2);

            if (margin < 0) margin = 0;

            var styles = {
                root: {
                    position: 'relative',
                    margin: margin + 'px',
                    display: 'inline-block',
                    width: size,
                    height: size },
                wrapper: {

                    width: size,
                    height: size,
                    margin: '5px',
                    display: 'inline-block',
                    transition: Transitions.create('transform', '20s', null, 'linear')
                },
                svg: {
                    height: size,
                    position: 'relative',
                    transform: 'scale(' + zoom + ')',
                    width: size
                },
                path: {
                    strokeDasharray: '89,200',
                    strokeDashoffset: 0,
                    stroke: this.getTheme().primary1Color,
                    strokeLinecap: 'round',
                    transition: Transitions.create('all', '1.5s', null, 'ease-in-out')
                }
            };

            if (this.props.mode == 'determinate') {
                var relVal = this._getRelativeValue();
                styles.path.transition = Transitions.create('all', '0.3s', null, 'linear');
                styles.path.strokeDasharray = Math.round(relVal * 1.25) + ',200';
            } else {}

            return styles;
        },

        render: function render() {
            var _props = this.props;
            var style = _props.style;
            var size = _props.size;

            var other = _objectWithoutProperties(_props, ['style', 'size']);

            var styles = this.getStyles(size || 1);

            return React.createElement(
                'div',
                _extends({}, other, { style: this.mergeAndPrefix(styles.root, style) }),
                React.createElement(
                    'div',
                    { ref: 'wrapper', style: this.mergeAndPrefix(styles.wrapper) },
                    React.createElement(
                        'svg',
                        { style: this.mergeAndPrefix(styles.svg) },
                        React.createElement('circle', { ref: 'path', style: this.mergeAndPrefix(styles.path), cx: '25', cy: '25', r: '20', fill: 'none', strokeWidth: '2.5', strokeMiterlimit: '10' })
                    )
                )
            );
        }
    });

    module.exports = CircularProgress;
},{"./mixins/style-propable":36,"./styles/transitions":55,"react":"react"}],6:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var BeforeAfterWrapper = require('./before-after-wrapper');

    var ClearFix = React.createClass({
        displayName: 'ClearFix',

        render: function render() {
            var _props = this.props;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['style']);

            var before = function before() {
                return {
                    content: '\' \'',
                    display: 'table'
                };
            };

            var after = before();
            after.clear = 'both';

            return React.createElement(
                BeforeAfterWrapper,
                _extends({}, other, {
                    beforeStyle: before(),
                    afterStyle: after,
                    style: this.props.style }),
                this.props.children
            );
        }
    });

    module.exports = ClearFix;
},{"./before-after-wrapper":3,"react":"react"}],7:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var DateTime = require('../utils/date-time');
    var DayButton = require('./day-button');
    var ClearFix = require('../clearfix');

    var CalendarMonth = React.createClass({
        displayName: 'CalendarMonth',

        propTypes: {
            displayDate: React.PropTypes.object.isRequired,
            onDayTouchTap: React.PropTypes.func,
            selectedDate: React.PropTypes.object.isRequired,
            minDate: React.PropTypes.object,
            maxDate: React.PropTypes.object,
            shouldDisableDate: React.PropTypes.func,
            autoOk: React.PropTypes.bool
        },

        render: function render() {
            var styles = {
                lineHeight: '32px',
                textAlign: 'center',
                padding: '8px 14px 0 14px' };

            return React.createElement(
                'div',
                { style: styles },
                this._getWeekElements()
            );
        },

        isSelectedDateDisabled: function isSelectedDateDisabled() {
            return this._selectedDateDisabled;
        },

        _getWeekElements: function _getWeekElements() {
            var weekArray = DateTime.getWeekArray(this.props.displayDate);

            return weekArray.map(function (week, i) {
                return React.createElement(
                    ClearFix,
                    { key: i },
                    this._getDayElements(week, i)
                );
            }, this);
        },

        _getDayElements: function _getDayElements(week, i) {
            return week.map(function (day, j) {
                var isSameDate = DateTime.isEqualDate(this.props.selectedDate, day);
                var disabled = this._shouldDisableDate(day);
                var selected = !disabled && isSameDate;

                if (isSameDate) {
                    if (disabled) {
                        this._selectedDateDisabled = true;
                    } else {
                        this._selectedDateDisabled = false;
                    }
                }

                return React.createElement(DayButton, {
                    key: 'db' + i + j,
                    date: day,
                    onTouchTap: this._handleDayTouchTap,
                    selected: selected,
                    disabled: disabled });
            }, this);
        },

        _handleDayTouchTap: function _handleDayTouchTap(e, date) {
            if (this.props.onDayTouchTap) this.props.onDayTouchTap(e, date);
        },

        _shouldDisableDate: function _shouldDisableDate(day) {
            if (day === null) return false;
            var disabled = !DateTime.isBetweenDates(day, this.props.minDate, this.props.maxDate);
            if (!disabled && this.props.shouldDisableDate) disabled = this.props.shouldDisableDate(day);

            return disabled;
        }

    });

    module.exports = CalendarMonth;
},{"../clearfix":6,"../utils/date-time":93,"./day-button":14,"react":"react"}],8:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var DateTime = require('../utils/date-time');
    var IconButton = require('../icon-button');
    var Toolbar = require('../toolbar/toolbar');
    var ToolbarGroup = require('../toolbar/toolbar-group');
    var DropDownMenu = require('../drop-down-menu');
    var NavigationChevronLeft = require('../svg-icons/navigation-chevron-left');
    var NavigationChevronLeftDouble = require('../svg-icons/navigation-chevron-left-double');
    var NavigationChevronRight = require('../svg-icons/navigation-chevron-right');
    var NavigationChevronRightDouble = require('../svg-icons/navigation-chevron-right-double');
    var SlideInTransitionGroup = require('../transition-groups/slide-in');

    var CalendarToolbar = React.createClass({
        displayName: 'CalendarToolbar',

        propTypes: {
            displayDate: React.PropTypes.object.isRequired,
            onMonthChange: React.PropTypes.func,
            onYearChange: React.PropTypes.func,
            prevYear: React.PropTypes.bool,
            nextYear: React.PropTypes.bool,
            prevMonth: React.PropTypes.bool,
            nextMonth: React.PropTypes.bool,
            hideYearChangeButtons: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                prevYear: true,
                nextYear: true,
                prevMonth: true,
                nextMonth: true,
                hideYearChangeButtons: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                transitionDirection: 'up'
            };
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            var direction;

            if (nextProps.displayDate !== this.props.displayDate) {
                direction = nextProps.displayDate > this.props.displayDate ? 'up' : 'down';
                this.setState({
                    transitionDirection: direction
                });
            }
        },

        _styles: function _styles() {
            return {
                root: {
                    position: 'relative',
                    padding: 0,
                    backgroundColor: 'inherit'
                },

                title: {
                    position: 'absolute',
                    top: '17px',
                    lineHeight: '14px',
                    fontSize: '14px',
                    height: '14px',
                    width: '100%',
                    fontWeight: '500',
                    textAlign: 'center',
                    zIndex: -1
                }
            };
        },

        render: function render() {
            var month = DateTime.getFullMonth(this.props.displayDate);
            var year = this.props.displayDate.getFullYear();
            var prevYearChangeButton = this._getPrevYearChangeButton();
            var nextYearChangeButton = this._getNextYearChangeButton();
            var styles = this._styles();

            return React.createElement(
                Toolbar,
                { className: 'mui-date-picker-calendar-toolbar', style: styles.root, noGutter: true },
                React.createElement(
                    ToolbarGroup,
                    { key: 0, float: 'left' },
                    prevYearChangeButton,
                    React.createElement(
                        IconButton,
                        {
                            disabled: !this.props.prevMonth,
                            onTouchTap: this._prevMonthTouchTap },
                        React.createElement(NavigationChevronLeft, null)
                    )
                ),
                React.createElement(
                    ToolbarGroup,
                    { key: 1, float: 'right' },
                    React.createElement(
                        IconButton,
                        {
                            disabled: !this.props.nextMonth,
                            onTouchTap: this._nextMonthTouchTap },
                        React.createElement(NavigationChevronRight, null)
                    ),
                    nextYearChangeButton
                ),
                React.createElement(
                    SlideInTransitionGroup,
                    {
                        style: styles.title,
                        direction: this.state.transitionDirection },
                    React.createElement(
                        'div',
                        { key: month + '_' + year },
                        month,
                        ' ',
                        year
                    )
                )
            );
        },

        _getPrevYearChangeButton: function _getPrevYearChangeButton() {
            var style = {
                display: this.props.hideYearChangeButtons ? 'none' : ''
            };

            return React.createElement(
                IconButton,
                {
                    style: style,
                    disabled: !this.props.prevYear,
                    onTouchTap: this._prevYearTouchTap },
                React.createElement(NavigationChevronLeftDouble, null)
            );
        },

        _getNextYearChangeButton: function _getNextYearChangeButton() {
            var style = {
                display: this.props.hideYearChangeButtons ? 'none' : ''
            };

            return React.createElement(
                IconButton,
                {
                    style: style,
                    disabled: !this.props.nextYear,
                    onTouchTap: this._nextYearTouchTap },
                React.createElement(NavigationChevronRightDouble, null)
            );
        },

        _prevYearTouchTap: function _prevYearTouchTap() {
            if (this.props.onYearChange && this.props.prevYear) this.props.onYearChange(-1);
        },

        _nextYearTouchTap: function _nextYearTouchTap() {
            if (this.props.onYearChange && this.props.nextYear) this.props.onYearChange(1);
        },

        _prevMonthTouchTap: function _prevMonthTouchTap() {
            if (this.props.onMonthChange && this.props.prevMonth) this.props.onMonthChange(-1);
        },

        _nextMonthTouchTap: function _nextMonthTouchTap() {
            if (this.props.onMonthChange && this.props.nextMonth) this.props.onMonthChange(1);
        }

    });

    module.exports = CalendarToolbar;
},{"../drop-down-menu":19,"../icon-button":26,"../svg-icons/navigation-chevron-left":60,"../svg-icons/navigation-chevron-left-double":59,"../svg-icons/navigation-chevron-right":62,"../svg-icons/navigation-chevron-right-double":61,"../toolbar/toolbar":87,"../toolbar/toolbar-group":84,"../transition-groups/slide-in":90,"../utils/date-time":93,"react":"react"}],9:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var Colors = require('../styles/colors');
    var DateTime = require('../utils/date-time');
    var YearButton = require('./year-button');

    var CalendarYear = React.createClass({
        displayName: 'CalendarYear',

        mixins: [StylePropable],

        propTypes: {
            displayDate: React.PropTypes.object.isRequired,
            onYearTouchTap: React.PropTypes.func,
            selectedDate: React.PropTypes.object.isRequired,
            minDate: React.PropTypes.object,
            maxDate: React.PropTypes.object
        },

        componentDidMount: function componentDidMount() {
            this._scrollToSelectedYear();
        },

        componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
            this._scrollToSelectedYear();
        },

        render: function render() {
            var years = this._getYears();
            var styles = {
                position: 'relative',
                height: 'inherit',
                lineHeight: '36px',
                textAlign: 'center',
                padding: '8px 14px 0 14px',
                backgroundColor: Colors.white,
                overflowX: 'hidden',
                overflowY: 'scroll'
            };

            return React.createElement(
                'div',
                { style: styles },
                years
            );
        },

        _getYears: function _getYears() {
            var minYear = this.props.minDate.getFullYear();
            var maxYear = this.props.maxDate.getFullYear();

            var years = [];
            var dateCheck = DateTime.clone(this.props.selectedDate);
            for (var year = minYear; year <= maxYear; year++) {
                dateCheck.setFullYear(year);
                if (!DateTime.isBetweenDates(dateCheck, this.props.minDate, this.props.maxDate)) continue;
                var selected = this.props.selectedDate.getFullYear() === year;
                var selectedProps = {};
                if (selected) {
                    selectedProps = { ref: 'selectedYearButton' };
                }

                var yearButton = React.createElement(YearButton, _extends({
                    key: 'yb' + year,
                    year: year,
                    onTouchTap: this._handleYearTouchTap,
                    selected: selected
                }, selectedProps));

                years.push(yearButton);
            }

            return years;
        },

        _scrollToSelectedYear: function _scrollToSelectedYear() {
            if (this.refs.selectedYearButton === undefined) return;

            var container = this.getDOMNode();
            var yearButtonNode = this.refs.selectedYearButton.getDOMNode();

            var containerHeight = container.clientHeight;
            var yearButtonNodeHeight = yearButtonNode.clientHeight || 32;

            var scrollYOffset = yearButtonNode.offsetTop + yearButtonNodeHeight / 2 - containerHeight / 2;
            container.scrollTop = scrollYOffset;
        },

        _handleYearTouchTap: function _handleYearTouchTap(e, year) {
            if (this.props.onYearTouchTap) this.props.onYearTouchTap(e, year);
        }

    });

    module.exports = CalendarYear;
},{"../mixins/style-propable":36,"../styles/colors":50,"../utils/date-time":93,"./year-button":15,"react":"react"}],10:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var WindowListenable = require('../mixins/window-listenable');
    var DateTime = require('../utils/date-time');
    var KeyCode = require('../utils/key-code');
    var Transitions = require('../styles/transitions');
    var CalendarMonth = require('./calendar-month');
    var CalendarYear = require('./calendar-year');
    var CalendarToolbar = require('./calendar-toolbar');
    var DateDisplay = require('./date-display');
    var SlideInTransitionGroup = require('../transition-groups/slide-in');
    var ClearFix = require('../clearfix');

    var Calendar = React.createClass({
        displayName: 'Calendar',

        mixins: [StylePropable, WindowListenable],

        propTypes: {
            initialDate: React.PropTypes.object,
            isActive: React.PropTypes.bool,
            minDate: React.PropTypes.object,
            maxDate: React.PropTypes.object,
            shouldDisableDate: React.PropTypes.func,
            hideToolbarYearChange: React.PropTypes.bool,
            shouldShowMonthDayPickerFirst: React.PropTypes.bool,
            shouldShowYearPickerFirst: React.PropTypes.bool,
            showYearSelector: React.PropTypes.bool,
            onSelectedDate: React.PropTypes.func
        },

        windowListeners: {
            'keydown': '_handleWindowKeyDown'
        },

        getDefaultProps: function getDefaultProps() {
            return {
                initialDate: new Date(),
                minDate: DateTime.addYears(new Date(), -100),
                maxDate: DateTime.addYears(new Date(), 100),
                hideToolbarYearChange: false,
                shouldShowMonthDayPickerFirst: true,
                shouldShowYearPickerFirst: false,
                showYearSelector: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                displayDate: DateTime.getFirstDayOfMonth(this.props.initialDate),
                selectedDate: this.props.initialDate,
                transitionDirection: 'left',
                displayMonthDay: this.props.shouldShowMonthDayPickerFirst || this.props.shouldShowYearPickerFirst || true,
                transitionEnter: true
            };
        },

        getStyles: function getStyles() {},

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            if (nextProps.initialDate !== this.props.initialDate) {
                var d = nextProps.initialDate || new Date();
                this.setState({
                    displayDate: DateTime.getFirstDayOfMonth(d),
                    selectedDate: d
                });
            }

            if (nextProps.shouldShowMonthDayPickerFirst) {
                this.setState({ displayMonthDay: nextProps.shouldShowMonthDayPickerFirst });
            }
        },

        render: function render() {
            var yearCount = DateTime.yearDiff(this.props.maxDate, this.props.minDate) + 1;
            var weekCount = DateTime.getWeekArray(this.state.displayDate).length;
            var toolbarInteractions = this._getToolbarInteractions();
            var hideYearChangeButtons = this.props.hideToolbarYearChange || !this.props.showYearSelector;
            var isMultiYearRange = yearCount > 2; // Want a year range greater than 1. Ex. [2014,2016] has a count of 3
            var isLandscape = this.props.mode === 'landscape';
            var styles = {
                root: {
                    fontSize: '12px'
                },
                calendarContainer: {
                    width: isLandscape ? '280px' : '100%',
                    height: weekCount === 5 ? '268px' : weekCount === 6 ? '308px' : '228px',
                    float: isLandscape ? 'right' : 'none',
                    transition: Transitions.easeOut('150ms', 'height')
                },
                yearContainer: {
                    width: '280px',
                    overflow: 'hidden',
                    height: yearCount < 6 ? yearCount * 56 + 10 : weekCount === 5 ? '268px' : weekCount === 6 ? '308px' : '228px',
                    float: isLandscape ? 'right' : 'none'
                },
                dateDisplay: {
                    width: isLandscape ? '280px' : '100%',
                    height: '100%',
                    float: isLandscape ? 'left' : 'none'
                },
                weekTitle: {
                    padding: '0 14px',
                    lineHeight: '12px',
                    opacity: '0.5',
                    height: '12px',
                    fontWeight: '500',
                    margin: 0
                },
                weekTitleDay: {
                    listStyle: 'none',
                    float: 'left',
                    width: '32px',
                    textAlign: 'center',
                    margin: '0 2px'
                }
            };

            if (this.state.displayMonthDay || !this.props.showYearSelector) {
                styles.yearContainer.display = 'none';
            } else {
                styles.calendarContainer.display = 'none';
            }

            return React.createElement(
                ClearFix,
                { style: this.mergeAndPrefix(styles.root) },
                React.createElement(DateDisplay, {
                    style: styles.dateDisplay,
                    selectedDate: this.state.selectedDate,
                    handleMonthDayClick: this._handleMonthDayClick,
                    handleYearClick: this._handleYearClick,
                    yearSelectionAvailable: this.props.showYearSelector && isMultiYearRange,
                    monthDaySelected: this.state.displayMonthDay,
                    mode: this.props.mode,
                    weekCount: weekCount }),
                React.createElement(
                    'div',
                    { style: styles.calendarContainer },
                    React.createElement(CalendarToolbar, {
                        displayDate: this.state.displayDate,
                        onMonthChange: this._handleMonthChange,
                        onYearChange: this._handleYearChange,
                        prevMonth: toolbarInteractions.prevMonth,
                        nextMonth: toolbarInteractions.nextMonth,
                        prevYear: toolbarInteractions.prevYear,
                        nextYear: toolbarInteractions.nextYear,
                        hideYearChangeButtons: hideYearChangeButtons }),
                    React.createElement(
                        ClearFix,
                        {
                            elementType: 'ul',
                            style: styles.weekTitle },
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'S'
                        ),
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'M'
                        ),
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'T'
                        ),
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'W'
                        ),
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'T'
                        ),
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'F'
                        ),
                        React.createElement(
                            'li',
                            { style: styles.weekTitleDay },
                            'S'
                        )
                    ),
                    React.createElement(
                        SlideInTransitionGroup,
                        {
                            direction: this.state.transitionDirection },
                        React.createElement(CalendarMonth, {
                            key: this.state.displayDate.toDateString(),
                            ref: 'calendar',
                            displayDate: this.state.displayDate,
                            onDayTouchTap: this._handleDayTouchTap,
                            selectedDate: this.state.selectedDate,
                            minDate: this.props.minDate,
                            maxDate: this.props.maxDate,
                            shouldDisableDate: this.props.shouldDisableDate })
                    )
                ),
                React.createElement(
                    'div',
                    { style: styles.yearContainer },
                    this._yearSelector()
                )
            );
        },

        _yearSelector: function _yearSelector() {
            if (this.props.showYearSelector) {
                return React.createElement(CalendarYear, {
                    key: 'years',
                    displayDate: this.state.displayDate,
                    onYearTouchTap: this._handleYearTouchTap,
                    selectedDate: this.state.selectedDate,
                    minDate: this.props.minDate,
                    maxDate: this.props.maxDate });
            }
        },

        getSelectedDate: function getSelectedDate() {
            return this.state.selectedDate;
        },

        isSelectedDateDisabled: function isSelectedDateDisabled() {
            return this.refs.calendar.isSelectedDateDisabled();
        },

        _addSelectedDays: function _addSelectedDays(days) {
            this._setSelectedDate(DateTime.addDays(this.state.selectedDate, days));
        },

        _addSelectedMonths: function _addSelectedMonths(months) {
            this._setSelectedDate(DateTime.addMonths(this.state.selectedDate, months));
        },

        _addSelectedYears: function _addSelectedYears(years) {
            this._setSelectedDate(DateTime.addYears(this.state.selectedDate, years));
        },

        _setDisplayDate: function _setDisplayDate(d, newSelectedDate) {
            var newDisplayDate = DateTime.getFirstDayOfMonth(d);
            var direction = newDisplayDate > this.state.displayDate ? 'left' : 'right';

            if (newDisplayDate !== this.state.displayDate) {
                this.setState({
                    displayDate: newDisplayDate,
                    transitionDirection: direction,
                    selectedDate: newSelectedDate || this.state.selectedDate
                });
            }
        },

        _setSelectedDate: function _setSelectedDate(date, e) {
            var adjustedDate = date;
            if (DateTime.isBeforeDate(date, this.props.minDate)) {
                adjustedDate = this.props.minDate;
            } else if (DateTime.isAfterDate(date, this.props.maxDate)) {
                adjustedDate = this.props.maxDate;
            }

            var newDisplayDate = DateTime.getFirstDayOfMonth(adjustedDate);
            if (newDisplayDate !== this.state.displayDate) {
                this._setDisplayDate(newDisplayDate, adjustedDate);
            } else {
                this.setState({
                    selectedDate: adjustedDate
                });
            }
            if (this.props.onSelectedDate) this.props.onSelectedDate(e, date);
        },

        _handleDayTouchTap: function _handleDayTouchTap(e, date) {
            this._setSelectedDate(date, e);
        },

        _handleMonthChange: function _handleMonthChange(months) {
            this._addSelectedMonths(months);
        },

        _handleYearChange: function _handleYearChange(years) {
            this._addSelectedYears(years);
        },

        _handleYearTouchTap: function _handleYearTouchTap(e, year) {
            var date = DateTime.clone(this.state.selectedDate);
            date.setFullYear(year);
            this._setSelectedDate(date, e);
        },

        _getToolbarInteractions: function _getToolbarInteractions() {
            return {
                prevMonth: DateTime.monthDiff(this.state.selectedDate, this.props.minDate) > 0,
                nextMonth: DateTime.monthDiff(this.state.selectedDate, this.props.maxDate) < 0,
                prevYear: DateTime.yearDiff(this.state.selectedDate, this.props.minDate) > 0,
                nextYear: DateTime.yearDiff(this.state.selectedDate, this.props.maxDate) < 0
            };
        },

        _handleMonthDayClick: function _handleMonthDayClick() {
            this.setState({ displayMonthDay: true });
        },

        _handleYearClick: function _handleYearClick() {
            this.setState({ displayMonthDay: false });
        },

        _handleWindowKeyDown: function _handleWindowKeyDown(e) {
            if (this.props.isActive) {

                switch (e.keyCode) {
                    case KeyCode.UP:
                        if (e.altKey && e.shiftKey) {
                            this._addSelectedYears(-1);
                        } else if (e.shiftKey) {
                            this._addSelectedMonths(-1);
                        } else {
                            this._addSelectedDays(-7);
                        }
                        break;

                    case KeyCode.DOWN:
                        if (e.altKey && e.shiftKey) {
                            this._addSelectedYears(1);
                        } else if (e.shiftKey) {
                            this._addSelectedMonths(1);
                        } else {
                            this._addSelectedDays(7);
                        }
                        break;

                    case KeyCode.RIGHT:
                        if (e.altKey && e.shiftKey) {
                            this._addSelectedYears(1);
                        } else if (e.shiftKey) {
                            this._addSelectedMonths(1);
                        } else {
                            this._addSelectedDays(1);
                        }
                        break;

                    case KeyCode.LEFT:
                        if (e.altKey && e.shiftKey) {
                            this._addSelectedYears(-1);
                        } else if (e.shiftKey) {
                            this._addSelectedMonths(-1);
                        } else {
                            this._addSelectedDays(-1);
                        }
                        break;
                }
            }
        }

    });

    module.exports = Calendar;
},{"../clearfix":6,"../mixins/style-propable":36,"../mixins/window-listenable":38,"../styles/transitions":55,"../transition-groups/slide-in":90,"../utils/date-time":93,"../utils/key-code":97,"./calendar-month":7,"./calendar-toolbar":8,"./calendar-year":9,"./date-display":11,"react":"react"}],11:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var DateTime = require('../utils/date-time');
    var Transitions = require('../styles/transitions');
    var AutoPrefix = require('../styles/auto-prefix');
    var SlideInTransitionGroup = require('../transition-groups/slide-in');

    var DateDisplay = React.createClass({
        displayName: 'DateDisplay',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            selectedDate: React.PropTypes.object.isRequired,
            weekCount: React.PropTypes.number,
            yearSelectionAvailable: React.PropTypes.bool,
            monthDaySelected: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                weekCount: 4,
                yearSelectionAvailable: true,
                monthDaySelected: true
            };
        },

        getInitialState: function getInitialState() {
            return {
                transitionDirection: 'up',
                selectedYear: !this.props.monthDaySelected
            };
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            var direction;

            if (nextProps.selectedDate !== this.props.selectedDate) {
                direction = nextProps.selectedDate > this.props.selectedDate ? 'up' : 'down';
                this.setState({
                    transitionDirection: direction
                });
            }

            if (nextProps.monthDaySelected !== undefined) {
                this.setState({ selectedYear: !nextProps.monthDaySelected });
            }
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.datePicker;
        },

        render: function render() {
            var _props = this.props;
            var selectedDate = _props.selectedDate;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['selectedDate', 'style']);

            var dayOfWeek = DateTime.getDayOfWeek(this.props.selectedDate);
            var month = DateTime.getShortMonth(this.props.selectedDate);
            var day = this.props.selectedDate.getDate();
            var year = this.props.selectedDate.getFullYear();

            var isLandscape = this.props.mode === 'landscape';
            var dateYPosition = '0px';
            var dayYPosition = '30px';
            var yearYPosition = '95px';

            if (isLandscape) {
                dateYPosition = this.props.weekCount === 5 ? '14px' : this.props.weekCount === 6 ? '34px' : '8px';
                yearYPosition = this.props.weekCount === 4 ? '114px' : '150px';
                if (this.props.weekCount > 4) dayYPosition = '50px';
            }

            var styles = {
                root: {
                    textAlign: 'center',
                    position: 'relative'
                },

                dateContainer: {
                    backgroundColor: this.getTheme().color,
                    height: isLandscape ? this.props.weekCount * 40 + 36 + 'px' : '150px',
                    padding: '16px 0',
                    transition: Transitions.easeOut(),
                    boxSizing: 'border-box' },

                date: {
                    position: 'relative',
                    color: this.getTheme().textColor,
                    transition: Transitions.easeOut(),
                    transform: 'translate3d(0,' + dateYPosition + ',0)'
                },

                dowContainer: {
                    height: '32px',
                    backgroundColor: this.getTheme().selectColor,
                    borderRadius: isLandscape ? '2px 0 0 0' : '2px 2px 0 0',
                    paddingTop: '9px',
                    boxSizing: 'border-box'
                },

                dow: {
                    fontSize: '13px',
                    lineHeight: '13px',
                    height: '100%',
                    color: this.getTheme().selectTextColor
                },

                day: {
                    root: {
                        position: 'absolute',
                        lineHeight: isLandscape ? '76px' : '58px',
                        fontSize: isLandscape ? '76px' : '58px',
                        height: isLandscape ? '76px' : '58px',
                        width: '100%',
                        opacity: this.state.selectedYear ? '0.7' : '1.0',
                        transition: Transitions.easeOut(),
                        transform: 'translate3d(0,' + dayYPosition + ',0)'
                    },

                    title: {
                        width: '100px',
                        marginLeft: 'auto',
                        marginRight: 'auto',
                        cursor: !this.state.selectedYear ? 'default' : 'pointer'
                    }
                },

                month: {
                    root: {
                        position: 'absolute',
                        top: isLandscape ? '0px' : '1px',
                        fontSize: isLandscape ? '26px' : '22px',
                        lineHeight: isLandscape ? '26px' : '22px',
                        height: isLandscape ? '26px' : '22px',
                        width: '100%',
                        textTransform: 'uppercase',
                        opacity: this.state.selectedYear ? '0.7' : '1.0'
                    },

                    title: {
                        width: '100px',
                        marginLeft: 'auto',
                        marginRight: 'auto',
                        cursor: !this.state.selectedYear ? 'default' : 'pointer'
                    }
                },

                year: {
                    root: {
                        position: 'absolute',
                        margin: '0px',
                        fontSize: isLandscape ? '26px' : '22px',
                        lineHeight: isLandscape ? '26px' : '22px',
                        height: isLandscape ? '26px' : '22px',
                        width: '100%',
                        textTransform: 'uppercase',
                        opacity: this.state.selectedYear ? '1.0' : '0.7',
                        transition: Transitions.easeOut(),
                        transform: 'translate3d(0,' + yearYPosition + ',0)'
                    },

                    title: {
                        width: '100px',
                        marginLeft: 'auto',
                        marginRight: 'auto',
                        cursor: !this.props.yearSelectionAvailable || this.state.selectedYear ? 'default' : 'pointer'
                    }
                }
            };

            return React.createElement(
                'div',
                _extends({}, other, { style: this.mergeAndPrefix(styles.root, this.props.style) }),
                React.createElement(
                    'div',
                    { style: styles.dowContainer },
                    React.createElement(
                        SlideInTransitionGroup,
                        {
                            style: styles.dow,
                            direction: this.state.transitionDirection },
                        React.createElement(
                            'div',
                            { key: dayOfWeek },
                            dayOfWeek
                        )
                    )
                ),
                React.createElement(
                    'div',
                    { style: AutoPrefix.all(styles.dateContainer) },
                    React.createElement(
                        'div',
                        { style: AutoPrefix.all(styles.date) },
                        React.createElement(
                            SlideInTransitionGroup,
                            {
                                style: styles.month.root,
                                direction: this.state.transitionDirection },
                            React.createElement(
                                'div',
                                { key: month, style: styles.month.title, onTouchTap: this._handleMonthDayClick },
                                month
                            )
                        ),
                        React.createElement(
                            SlideInTransitionGroup,
                            {
                                style: styles.day.root,
                                direction: this.state.transitionDirection },
                            React.createElement(
                                'div',
                                { key: day, style: styles.day.title, onTouchTap: this._handleMonthDayClick },
                                day
                            )
                        ),
                        React.createElement(
                            SlideInTransitionGroup,
                            {
                                style: styles.year.root,
                                direction: this.state.transitionDirection },
                            React.createElement(
                                'div',
                                { key: year, style: styles.year.title, onTouchTap: this._handleYearClick },
                                year
                            )
                        )
                    )
                )
            );
        },

        _handleMonthDayClick: function _handleMonthDayClick() {
            if (this.props.handleMonthDayClick && this.state.selectedYear) {
                this.props.handleMonthDayClick();
            }

            if (this.props.yearSelectionAvailable) this.setState({ selectedYear: false });
        },

        _handleYearClick: function _handleYearClick() {
            if (this.props.handleYearClick && !this.state.selectedYear && this.props.yearSelectionAvailable) {
                this.props.handleYearClick();
            }

            if (this.props.yearSelectionAvailable) this.setState({ selectedYear: true });
        }

    });

    module.exports = DateDisplay;
},{"../mixins/style-propable":36,"../styles/auto-prefix":49,"../styles/transitions":55,"../transition-groups/slide-in":90,"../utils/date-time":93,"react":"react"}],12:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var WindowListenable = require('../mixins/window-listenable');
    var CssEvent = require('../utils/css-event');
    var KeyCode = require('../utils/key-code');
    var Calendar = require('./calendar');
    var DialogWindow = require('../dialog-window');
    var FlatButton = require('../flat-button');

    var DatePickerDialog = React.createClass({
        displayName: 'DatePickerDialog',

        mixins: [StylePropable, WindowListenable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            initialDate: React.PropTypes.object,
            onAccept: React.PropTypes.func,
            onShow: React.PropTypes.func,
            onDismiss: React.PropTypes.func,
            onClickAway: React.PropTypes.func,
            minDate: React.PropTypes.object,
            maxDate: React.PropTypes.object,
            shouldDisableDate: React.PropTypes.func,
            hideToolbarYearChange: React.PropTypes.bool,
            showYearSelector: React.PropTypes.bool
        },

        windowListeners: {
            'keyup': '_handleWindowKeyUp'
        },

        getInitialState: function getInitialState() {
            return {
                isCalendarActive: false,
                showMonthDayPicker: true
            };
        },

        render: function render() {
            var _props = this.props;
            var initialDate = _props.initialDate;
            var onAccept = _props.onAccept;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['initialDate', 'onAccept', 'style']);

            var styles = {
                root: {
                    fontSize: '14px',
                    color: this.context.muiTheme.component.datePicker.calendarTextColor
                },

                dialogContents: {
                    width: this.props.mode === 'landscape' ? '560px' : '280px'
                },

                actions: {
                    marginRight: 8 }
            };

            var actions = [React.createElement(FlatButton, {
                key: 0,
                label: 'Cancel',
                secondary: true,
                style: styles.actions,
                onTouchTap: this._handleCancelTouchTap }), React.createElement(FlatButton, {
                key: 1,
                label: 'OK',
                secondary: true,
                disabled: this.refs.calendar !== undefined && this.refs.calendar.isSelectedDateDisabled(),
                style: styles.actions,
                onTouchTap: this._handleOKTouchTap })];

            if (this.props.autoOk) {
                actions = actions.slice(0, 1);
            }

            return React.createElement(
                DialogWindow,
                _extends({}, other, {
                    ref: 'dialogWindow',
                    style: styles.root,
                    contentStyle: styles.dialogContents,
                    actions: actions,
                    onDismiss: this._handleDialogDismiss,
                    onShow: this._handleDialogShow,
                    onClickAway: this._handleDialogClickAway,
                    repositionOnUpdate: false }),
                React.createElement(Calendar, {
                    ref: 'calendar',
                    onSelectedDate: this._onSelectedDate,
                    initialDate: this.props.initialDate,
                    isActive: this.state.isCalendarActive,
                    minDate: this.props.minDate,
                    maxDate: this.props.maxDate,
                    shouldDisableDate: this.props.shouldDisableDate,
                    shouldShowMonthDayPickerFirst: this.state.showMonthDayPicker,
                    hideToolbarYearChange: this.props.hideToolbarYearChange,
                    showYearSelector: this.props.showYearSelector,
                    mode: this.props.mode })
            );
        },

        show: function show() {
            this.refs.dialogWindow.show();
        },

        dismiss: function dismiss() {
            this.refs.dialogWindow.dismiss();
        },

        _onSelectedDate: function _onSelectedDate(e) {
            if (this.props.autoOk) {
                setTimeout(this._handleOKTouchTap, 300);
            }
        },

        _handleCancelTouchTap: function _handleCancelTouchTap() {
            this.dismiss();
        },

        _handleOKTouchTap: function _handleOKTouchTap() {
            if (this.props.onAccept && !this.refs.calendar.isSelectedDateDisabled()) {
                this.props.onAccept(this.refs.calendar.getSelectedDate());
            }

            this.dismiss();
        },

        _handleDialogShow: function _handleDialogShow() {
            this.setState({
                isCalendarActive: true
            });

            if (this.props.onShow) this.props.onShow();
        },

        _handleDialogDismiss: function _handleDialogDismiss() {
            CssEvent.onTransitionEnd(this.refs.dialogWindow.getDOMNode(), (function () {
                this.setState({
                    isCalendarActive: false,
                    showMonthDayPicker: true
                });
            }).bind(this));

            if (this.props.onDismiss) this.props.onDismiss();
        },

        _handleDialogClickAway: function _handleDialogClickAway() {
            CssEvent.onTransitionEnd(this.refs.dialogWindow.getDOMNode(), (function () {
                this.setState({
                    isCalendarActive: false,
                    showMonthDayPicker: true
                });
            }).bind(this));

            if (this.props.onClickAway) this.props.onClickAway();
        },

        _handleWindowKeyUp: function _handleWindowKeyUp(e) {
            if (this.refs.dialogWindow.isOpen()) {
                switch (e.keyCode) {
                    case KeyCode.ENTER:
                        this._handleOKTouchTap();
                        break;
                }
            }
        }

    });

    module.exports = DatePickerDialog;
},{"../dialog-window":16,"../flat-button":23,"../mixins/style-propable":36,"../mixins/window-listenable":38,"../utils/css-event":92,"../utils/key-code":97,"./calendar":10,"react":"react"}],13:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var WindowListenable = require('../mixins/window-listenable');
    var DateTime = require('../utils/date-time');
    var DatePickerDialog = require('./date-picker-dialog');
    var TextField = require('../text-field');

    var DatePicker = React.createClass({
        displayName: 'DatePicker',

        mixins: [StylePropable, WindowListenable],

        propTypes: {
            defaultDate: React.PropTypes.object,
            formatDate: React.PropTypes.func,
            mode: React.PropTypes.oneOf(['portrait', 'landscape', 'inline']),
            onFocus: React.PropTypes.func,
            onTouchTap: React.PropTypes.func,
            onChange: React.PropTypes.func,
            onShow: React.PropTypes.func,
            onDismiss: React.PropTypes.func,
            minDate: React.PropTypes.object,
            maxDate: React.PropTypes.object,
            shouldDisableDate: React.PropTypes.func,
            hideToolbarYearChange: React.PropTypes.bool,
            autoOk: React.PropTypes.bool,
            showYearSelector: React.PropTypes.bool
        },

        windowListeners: {
            'keyup': '_handleWindowKeyUp'
        },

        getDefaultProps: function getDefaultProps() {
            return {
                formatDate: DateTime.format,
                autoOk: false,
                showYearSelector: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                date: this.props.defaultDate,
                dialogDate: new Date()
            };
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            if (this.props.defaultDate !== nextProps.defaultDate) {
                this.setDate(nextProps.defaultDate);
            }
        },

        render: function render() {
            var _props = this.props;
            var formatDate = _props.formatDate;
            var mode = _props.mode;
            var onFocus = _props.onFocus;
            var onTouchTap = _props.onTouchTap;
            var onShow = _props.onShow;
            var onDismiss = _props.onDismiss;
            var minDate = _props.minDate;
            var maxDate = _props.maxDate;
            var autoOk = _props.autoOk;
            var showYearSelector = _props.showYearSelector;

            var other = _objectWithoutProperties(_props, ['formatDate', 'mode', 'onFocus', 'onTouchTap', 'onShow', 'onDismiss', 'minDate', 'maxDate', 'autoOk', 'showYearSelector']);

            var defaultInputValue;

            if (this.props.defaultDate) {
                defaultInputValue = this.props.formatDate(this.props.defaultDate);
            }

            return React.createElement(
                'div',
                { style: this.props.style },
                React.createElement(TextField, _extends({}, other, {
                    ref: 'input',
                    defaultValue: defaultInputValue,
                    onFocus: this._handleInputFocus,
                    onTouchTap: this._handleInputTouchTap })),
                React.createElement(DatePickerDialog, {
                    ref: 'dialogWindow',
                    mode: this.props.mode,
                    initialDate: this.state.dialogDate,
                    onAccept: this._handleDialogAccept,
                    onShow: onShow,
                    onDismiss: this._handleDialogDismiss,
                    minDate: minDate,
                    maxDate: maxDate,
                    autoOk: autoOk,
                    showYearSelector: showYearSelector,
                    shouldDisableDate: this.props.shouldDisableDate,
                    hideToolbarYearChange: this.props.hideToolbarYearChange })
            );
        },

        getDate: function getDate() {
            return this.state.date;
        },

        setDate: function setDate(d) {
            this.setState({
                date: d
            });
            this.refs.input.setValue(this.props.formatDate(d));
        },

        _handleDialogAccept: function _handleDialogAccept(d) {
            this.setDate(d);
            if (this.props.onChange) this.props.onChange(null, d);
        },

        _handleDialogDismiss: function _handleDialogDismiss() {
            if (this.props.onDismiss) this.props.onDismiss();
        },

        _handleInputFocus: function _handleInputFocus(e) {
            e.target.blur();
            if (this.props.onFocus) this.props.onFocus(e);
        },

        _handleInputTouchTap: function _handleInputTouchTap(e) {
            this.setState({
                dialogDate: this.getDate()
            });

            this.refs.dialogWindow.show();
            if (this.props.onTouchTap) this.props.onTouchTap(e);
        },

        _handleWindowKeyUp: function _handleWindowKeyUp() {}

    });

    module.exports = DatePicker;

//TO DO: open the dialog if input has focus
},{"../mixins/style-propable":36,"../mixins/window-listenable":38,"../text-field":71,"../utils/date-time":93,"./date-picker-dialog":12,"react":"react"}],14:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var Transition = require('../styles/transitions');
    var DateTime = require('../utils/date-time');
    var EnhancedButton = require('../enhanced-button');

    var DayButton = React.createClass({
        displayName: 'DayButton',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            date: React.PropTypes.object,
            onTouchTap: React.PropTypes.func,
            selected: React.PropTypes.bool,
            disabled: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                selected: false,
                disabled: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                hover: false
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.datePicker;
        },

        render: function render() {
            var _props = this.props;
            var date = _props.date;
            var onTouchTap = _props.onTouchTap;
            var selected = _props.selected;

            var other = _objectWithoutProperties(_props, ['date', 'onTouchTap', 'selected']);

            var styles = {
                root: {
                    boxSizing: 'border-box',
                    WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                    position: 'relative',
                    float: 'left',
                    width: 36,
                    padding: '4px 2px'
                },

                label: {
                    position: 'relative',
                    color: this.context.muiTheme.palette.textColor
                },

                buttonState: {
                    position: 'absolute',
                    height: 32,
                    width: 32,
                    opacity: 0,
                    borderRadius: '50%',
                    transform: 'scale(0)',
                    transition: Transition.easeOut(),
                    backgroundColor: this.getTheme().selectColor }
            };

            if (this.state.hover) {
                styles.label.color = this.getTheme().selectTextColor;
                styles.buttonState.opacity = '0.6';
                styles.buttonState.transform = 'scale(1)';
            }

            if (this.props.selected) {
                styles.label.color = this.getTheme().selectTextColor;
                styles.buttonState.opacity = 1;
                styles.buttonState.transform = 'scale(1)';
            } else if (this.props.disabled) {
                styles.root.opacity = '0.6';
            }

            if (DateTime.isEqualDate(this.props.date, new Date()) && !this.props.selected) {
                styles.label.color = this.getTheme().color;
            }

            return this.props.date ? React.createElement(
                EnhancedButton,
                _extends({}, other, {
                    style: styles.root,
                    hoverStyle: styles.hover,
                    disabled: this.props.disabled,
                    disableFocusRipple: true,
                    disableTouchRipple: true,
                    onMouseOver: this._handleMouseOver,
                    onMouseOut: this._handleMouseOut,
                    onTouchTap: this._handleTouchTap,
                    onKeyboardFocus: this._handleKeyboardFocus }),
                React.createElement('div', { style: styles.buttonState }),
                React.createElement(
                    'span',
                    { style: styles.label },
                    this.props.date.getDate()
                )
            ) : React.createElement('span', { style: styles.root });
        },

        _handleMouseOver: function _handleMouseOver() {
            if (!this.props.disabled) this.setState({ hover: true });
        },

        _handleMouseOut: function _handleMouseOut() {
            if (!this.props.disabled) this.setState({ hover: false });
        },

        _handleTouchTap: function _handleTouchTap(e) {
            if (!this.props.disabled && this.props.onTouchTap) this.props.onTouchTap(e, this.props.date);
        },

        _handleKeyboardFocus: function _handleKeyboardFocus(e, keyboardFocused) {
            if (!this.props.disabled && this.props.onKeyboardFocus) this.props.onKeyboardFocus(e, keyboardFocused, this.props.date);
        }

    });

    module.exports = DayButton;
},{"../enhanced-button":20,"../mixins/style-propable":36,"../styles/transitions":55,"../utils/date-time":93,"react":"react"}],15:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var DateTime = require('../utils/date-time');
    var EnhancedButton = require('../enhanced-button');

    var YearButton = React.createClass({
        displayName: 'YearButton',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            year: React.PropTypes.number,
            onTouchTap: React.PropTypes.func,
            selected: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                selected: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                hover: false
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.datePicker;
        },

        render: function render() {
            var _props = this.props;
            var className = _props.className;
            var year = _props.year;
            var onTouchTap = _props.onTouchTap;
            var selected = _props.selected;

            var other = _objectWithoutProperties(_props, ['className', 'year', 'onTouchTap', 'selected']);

            var styles = {
                root: {
                    boxSizing: 'border-box',
                    WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                    position: 'relative',
                    display: 'block',
                    margin: '0 auto',
                    width: 36,
                    fontSize: '14px',
                    padding: '8px 2px'
                },

                label: {
                    position: 'relative',
                    top: '-1px',
                    color: this.context.muiTheme.palette.textColor
                },

                buttonState: {
                    position: 'absolute',
                    height: 32,
                    width: 32,
                    opacity: 0,
                    borderRadius: '50%',
                    transform: 'scale(0)',
                    backgroundColor: this.getTheme().selectColor
                } };

            if (this.state.hover) {
                styles.label.color = this.getTheme().selectTextColor;
                styles.buttonState.opacity = '0.6';
                styles.buttonState.transform = 'scale(1.5)';
            }

            if (selected) {
                styles.label.color = this.getTheme().selectTextColor;
                styles.buttonState.opacity = 1;
                styles.buttonState.transform = 'scale(1.5)';
            }

            if (year === new Date().getFullYear()) {
                styles.root.color = this.getTheme().color;
            }

            return React.createElement(
                EnhancedButton,
                _extends({}, other, {
                    style: styles.root,
                    disableFocusRipple: true,
                    disableTouchRipple: true,
                    onMouseOver: this._handleMouseOver,
                    onMouseOut: this._handleMouseOut,
                    onTouchTap: this._handleTouchTap }),
                React.createElement('div', { style: styles.buttonState }),
                React.createElement(
                    'span',
                    { style: styles.label },
                    year
                )
            );
        },

        _handleMouseOver: function _handleMouseOver() {
            this.setState({ hover: true });
        },

        _handleMouseOut: function _handleMouseOut() {
            this.setState({ hover: false });
        },

        _handleTouchTap: function _handleTouchTap(e) {
            if (this.props.onTouchTap) this.props.onTouchTap(e, this.props.year);
        }

    });

    module.exports = YearButton;
},{"../enhanced-button":20,"../mixins/style-propable":36,"../utils/date-time":93,"react":"react"}],16:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var WindowListenable = require('./mixins/window-listenable');
    var CssEvent = require('./utils/css-event');
    var KeyCode = require('./utils/key-code');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var FlatButton = require('./flat-button');
    var Overlay = require('./overlay');
    var Paper = require('./paper');

    var DialogWindow = React.createClass({
        displayName: 'DialogWindow',

        closeable: false,

        mixins: [WindowListenable, StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            actions: React.PropTypes.array,
            actionFocus: React.PropTypes.string,
            contentClassName: React.PropTypes.string,
            contentStyle: React.PropTypes.object,
            openImmediately: React.PropTypes.bool,
            onClickAway: React.PropTypes.func,
            onDismiss: React.PropTypes.func,
            onShow: React.PropTypes.func,
            repositionOnUpdate: React.PropTypes.bool,
            modal: React.PropTypes.bool
        },

        windowListeners: {
            'keyup': '_handleWindowKeyUp',
            'resize': '_positionDialog'
        },

        getDefaultProps: function getDefaultProps() {
            return {
                actions: [],
                repositionOnUpdate: true,
                modal: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                open: this.props.openImmediately || false
            };
        },

        componentDidMount: function componentDidMount() {
            this._positionDialog();
            if (this.props.openImmediately) {
                this.refs.dialogOverlay.preventScrolling();
                this._onShow();
                this._focusOnAction();
            }
        },

        componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
            this._positionDialog();
            this._focusOnAction();
        },

        getTheme: function getTheme() {
            return this.context.muiTheme;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    position: 'fixed',
                    boxSizing: 'border-box',
                    WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                    zIndex: 10,
                    top: 0,
                    left: -10000,
                    width: '100%',
                    height: '100%',
                    transition: Transitions.easeOut('0ms', 'left', '450ms'),
                    color: this.getTheme().palette.textColor
                },
                contents: {
                    boxSizing: 'border-box',
                    WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                    transition: Transitions.easeOut(),
                    position: 'relative',
                    width: '75%',
                    maxWidth: this.getSpacing().desktopKeylineIncrement * 12,
                    margin: '0 auto',
                    zIndex: 10,
                    background: this.getTheme().palette.canvasColor,
                    opacity: 0
                },
                rootWhenOpen: {
                    left: 2,
                    transition: Transitions.easeOut('0ms', 'left', '0ms')
                },
                contentsWhenOpen: {
                    opacity: 1,
                    top: 0,
                    transform: 'translate3d(0, ' + this.getSpacing().desktopKeylineIncrement + 'px, 0)'
                }
            };
            return styles;
        },

        render: function render() {
            var actions = this._getActionsContainer(this.props.actions);
            var styles = this.getStyles();

            return React.createElement(
                'div',
                { ref: 'container', style: this.mergeAndPrefix(styles.root, this.props.style, this.state.open && styles.rootWhenOpen) },
                React.createElement(
                    Paper,
                    {
                        ref: 'dialogWindow',
                        style: this.mergeAndPrefix(styles.contents, this.props.contentStyle, this.state.open && styles.contentsWhenOpen),
                        className: this.props.contentClassName,
                        zDepth: 4 },
                    this.props.children,
                    actions
                ),
                React.createElement(Overlay, { ref: 'dialogOverlay', show: this.state.open, autoLockScrolling: false, onTouchTap: this._handleOverlayTouchTap })
            );
        },

        isOpen: function isOpen() {
            return this.state.open;
        },

        dismiss: function dismiss() {
            if (this.closeable) {
                CssEvent.onTransitionEnd(React.findDOMNode(this), (function () {
                    this.refs.dialogOverlay.allowScrolling();
                }).bind(this));

                this.setState({ open: false });
                this._onDismiss();
            }
        },

        show: function show() {
            // prevent rapid show/hide
            setTimeout((function () {
                this.closeable = true;
            }).bind(this), 250);

            this.refs.dialogOverlay.preventScrolling();
            this._focusOnAction();
            this.setState({ open: true });
            this._onShow();
        },

        _getAction: function _getAction(actionJSON, key) {
            var _this = this;

            var styles = { marginRight: 8 };
            var props = {
                key: key,
                secondary: true,
                onClick: actionJSON.onClick,
                onTouchTap: function onTouchTap() {
                    if (actionJSON.onTouchTap) {
                        actionJSON.onTouchTap.call(undefined);
                    }
                    if (!(actionJSON.onClick || actionJSON.onTouchTap)) {
                        _this.dismiss();
                    }
                },
                label: actionJSON.text,
                style: styles
            };
            if (actionJSON.ref) {
                props.ref = actionJSON.ref;
                props.keyboardFocused = actionJSON.ref === this.props.actionFocus;
            }

            return React.createElement(FlatButton, props);
        },

        _getActionsContainer: function _getActionsContainer(actions) {
            //json w/ refs
            var actionContainer;
            var actionObjects = [];
            var actionStyle = {
                boxSizing: 'border-box',
                WebkitTapHighlightColor: 'rgba(s0,0,0,0)',
                padding: 8,
                marginBottom: 8,
                width: '100%',
                textAlign: 'right' };

            if (actions.length) {
                for (var i = 0; i < actions.length; i++) {
                    var currentAction = actions[i];

                    //if the current action isn't a react object, create one
                    if (!React.isValidElement(currentAction)) {
                        currentAction = this._getAction(currentAction, i);
                    }
                    actionObjects.push(currentAction);
                }

                actionContainer = React.createElement(
                    'div',
                    { style: actionStyle },
                    actionObjects
                );
            }

            return actionContainer;
        },

        _positionDialog: function _positionDialog() {
            var container = React.findDOMNode(this);
            var dialogWindow = React.findDOMNode(this.refs.dialogWindow);
            var containerHeight = container.offsetHeight;
            var dialogWindowHeight = dialogWindow.offsetHeight;

            //Reset the height in case the window was resized.
            dialogWindow.style.height = '';

            var paddingTop = Math.max((containerHeight - dialogWindowHeight) / 2 - 64, 0);

            //Vertically center the dialog window, but make sure it doesn't
            //transition to that position.
            if (this.props.repositionOnUpdate || !container.style.paddingTop) {
                container.style.paddingTop = paddingTop + 'px';
            }
        },

        _focusOnAction: function _focusOnAction() {
            if (this.props.actionFocus) {
                React.findDOMNode(this.refs[this.props.actionFocus]).focus();
            }
        },

        _onShow: function _onShow() {
            if (this.props.onShow) this.props.onShow();
        },

        _onDismiss: function _onDismiss() {
            if (this.props.onDismiss) this.props.onDismiss();
        },

        _handleOverlayTouchTap: function _handleOverlayTouchTap() {
            if (!this.props.modal && this.closeable) {
                this.dismiss();
                if (this.props.onClickAway) this.props.onClickAway();
            }
        },

        _handleWindowKeyUp: function _handleWindowKeyUp(e) {
            if (!this.props.modal && e.keyCode == KeyCode.ESC) {
                this.dismiss();
            }
        }

    });

    module.exports = DialogWindow;
},{"./flat-button":23,"./mixins/style-propable":36,"./mixins/window-listenable":38,"./overlay":39,"./paper":40,"./styles/transitions":55,"./utils/css-event":92,"./utils/key-code":97,"react":"react"}],17:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Spacing = require('./styles/spacing');
    var DialogWindow = require('./dialog-window');

    var Dialog = React.createClass({
        displayName: 'Dialog',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            title: React.PropTypes.node,
            contentInnerStyle: React.PropTypes.object },

        getStyles: function getStyles() {
            var gutter = Spacing.desktopGutter + 'px ';
            var styles = {
                title: {
                    margin: 0,
                    padding: gutter + gutter + '0 ' + gutter,
                    color: this.context.muiTheme.palette.textColor,
                    fontSize: '24px',
                    lineHeight: '32px',
                    fontWeight: '400' },
                content: {
                    padding: Spacing.desktopGutter
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var className = _props.className;
            var contentInnerStyle = _props.contentInnerStyle;

            var other = _objectWithoutProperties(_props, ['className', 'contentInnerStyle']);

            var styles = this.getStyles();

            var title;
            if (this.props.title) {
                // If the title is a string, wrap in an h3 tag.
                // If not, just use it as a node.
                title = Object.prototype.toString.call(this.props.title) === '[object String]' ? React.createElement(
                    'h3',
                    { style: styles.title },
                    this.props.title
                ) : this.props.title;
            }

            return React.createElement(
                DialogWindow,
                _extends({}, other, {
                    ref: 'dialogWindow',
                    className: className,
                    style: this.props.style }),
                title,
                React.createElement(
                    'div',
                    { ref: 'dialogContent', style: this.mergeAndPrefix(styles.content, contentInnerStyle) },
                    this.props.children
                )
            );
        },

        dismiss: function dismiss() {
            this.refs.dialogWindow.dismiss();
        },

        show: function show() {
            this.refs.dialogWindow.show();
        }

    });

    module.exports = Dialog;
},{"./dialog-window":16,"./mixins/style-propable":36,"./styles/spacing":51,"react":"react"}],18:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var Spacing = require('./styles/spacing');
    var ClickAwayable = require('./mixins/click-awayable');
    var FontIcon = require('./font-icon');
    var Menu = require('./menu/menu');

    var DropDownIcon = React.createClass({
        displayName: 'DropDownIcon',

        mixins: [StylePropable, ClickAwayable],

        propTypes: {
            onChange: React.PropTypes.func,
            menuItems: React.PropTypes.array.isRequired,
            closeOnMenuItemTouchTap: React.PropTypes.bool,
            iconStyle: React.PropTypes.object,
            iconClassName: React.PropTypes.string },

        getInitialState: function getInitialState() {
            return {
                open: false };
        },

        getDefaultProps: function getDefaultProps() {
            return {
                closeOnMenuItemTouchTap: true
            };
        },

        componentClickAway: function componentClickAway() {
            this.setState({ open: false });
        },

        getStyles: function getStyles() {
            var iconWidth = 48;
            var styles = {
                root: {
                    display: 'inline-block',
                    width: iconWidth + 'px !important',
                    position: 'relative',
                    height: Spacing.desktopToolbarHeight,
                    fontSize: Spacing.desktopDropDownMenuFontSize,
                    cursor: 'pointer'
                },
                menu: {
                    transition: Transitions.easeOut(),
                    right: '-14px !important',
                    top: '9px !important',
                    opacity: this.props.open ? 1 : 0
                },
                menuItem: { // similair to drop down menu's menu item styles
                    paddingRight: Spacing.iconSize + Spacing.desktopGutterLess * 2,
                    height: Spacing.desktopDropDownMenuItemHeight,
                    lineHeight: Spacing.desktopDropDownMenuItemHeight + 'px'
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var style = _props.style;
            var children = _props.children;
            var menuItems = _props.menuItems;
            var closeOnMenuItemTouchTap = _props.closeOnMenuItemTouchTap;
            var iconStyle = _props.iconStyle;
            var iconClassName = _props.iconClassName;

            var other = _objectWithoutProperties(_props, ['style', 'children', 'menuItems', 'closeOnMenuItemTouchTap', 'iconStyle', 'iconClassName']);

            var styles = this.getStyles();

            return React.createElement(
                'div',
                _extends({}, other, { style: this.mergeAndPrefix(styles.root, this.props.style) }),
                React.createElement(
                    'div',
                    { onTouchTap: this._onControlClick },
                    React.createElement(FontIcon, {
                        className: iconClassName,
                        style: iconStyle }),
                    this.props.children
                ),
                React.createElement(Menu, {
                    ref: 'menuItems',
                    style: this.mergeAndPrefix(styles.menu),
                    menuItems: menuItems,
                    menuItemStyle: styles.menuItem,
                    hideable: true,
                    visible: this.state.open,
                    onItemTap: this._onMenuItemClick })
            );
        },

        _onControlClick: function _onControlClick() {
            this.setState({ open: !this.state.open });
        },

        _onMenuItemClick: function _onMenuItemClick(e, key, payload) {
            if (this.props.onChange) this.props.onChange(e, key, payload);

            if (this.props.closeOnMenuItemTouchTap) {
                this.setState({ open: false });
            }
        }
    });

    module.exports = DropDownIcon;
},{"./font-icon":25,"./menu/menu":32,"./mixins/click-awayable":35,"./mixins/style-propable":36,"./styles/spacing":51,"./styles/transitions":55,"react":"react"}],19:[function(require,module,exports){
    (function (process){
        'use strict';

        var React = require('react');
        var StylePropable = require('./mixins/style-propable');
        var Transitions = require('./styles/transitions');
        var ClickAwayable = require('./mixins/click-awayable');
        var DropDownArrow = require('./svg-icons/drop-down-arrow');
        var Paper = require('./paper');
        var Menu = require('./menu/menu');
        var ClearFix = require('./clearfix');
        var DropDownMenu = React.createClass({
            displayName: 'DropDownMenu',

            mixins: [StylePropable, ClickAwayable],

            contextTypes: {
                muiTheme: React.PropTypes.object
            },

            // The nested styles for drop-down-menu are modified by toolbar and possibly
            // other user components, so it will give full access to its js styles rather
            // than just the parent.
            propTypes: {
                className: React.PropTypes.string,
                autoWidth: React.PropTypes.bool,
                onChange: React.PropTypes.func,
                menuItems: React.PropTypes.array.isRequired,
                menuItemStyle: React.PropTypes.object,
                selectedIndex: React.PropTypes.number
            },

            getDefaultProps: function getDefaultProps() {
                return {
                    autoWidth: true
                };
            },

            getInitialState: function getInitialState() {
                return {
                    open: false,
                    isHovered: false,
                    selectedIndex: this.props.selectedIndex || 0
                };
            },

            componentClickAway: function componentClickAway() {
                this.setState({ open: false });
            },

            componentDidMount: function componentDidMount() {
                if (this.props.autoWidth) this._setWidth();
                if (this.props.hasOwnProperty('selectedIndex')) this._setSelectedIndex(this.props);
            },

            componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
                if (nextProps.hasOwnProperty('selectedIndex')) {
                    this._setSelectedIndex(nextProps);
                }
            },

            getSpacing: function getSpacing() {
                return this.context.muiTheme.spacing;
            },

            getTextColor: function getTextColor() {
                return this.context.muiTheme.palette.textColor;
            },

            getStyles: function getStyles() {
                var accentColor = this.context.muiTheme.component.dropDownMenu.accentColor;
                var backgroundColor = this.context.muiTheme.component.menu.backgroundColor;
                var styles = {
                    root: {
                        transition: Transitions.easeOut(),
                        position: 'relative',
                        display: 'inline-block',
                        height: this.getSpacing().desktopToolbarHeight,
                        fontSize: this.getSpacing().desktopDropDownMenuFontSize
                    },
                    control: {
                        cursor: 'pointer',
                        position: 'static',
                        height: '100%'
                    },
                    controlBg: {
                        transition: Transitions.easeOut(),
                        backgroundColor: backgroundColor,
                        height: '100%',
                        width: '100%',
                        opacity: this.state.open ? 0 : this.state.isHovered ? 1 : 0
                    },
                    icon: {
                        position: 'absolute',
                        top: (this.getSpacing().desktopToolbarHeight - 24) / 2,
                        right: this.getSpacing().desktopGutterLess,
                        fill: this.context.muiTheme.component.dropDownMenu.accentColor
                    },
                    label: {
                        transition: Transitions.easeOut(),
                        lineHeight: this.getSpacing().desktopToolbarHeight + 'px',
                        position: 'absolute',
                        paddingLeft: this.getSpacing().desktopGutter,
                        top: 0,
                        opacity: 1,
                        color: this.getTextColor()
                    },
                    underline: {
                        borderTop: 'solid 1px ' + accentColor,
                        margin: '0 ' + this.getSpacing().desktopGutter + 'px'
                    },
                    menuItem: {
                        paddingRight: this.getSpacing().iconSize + this.getSpacing().desktopGutterLess + this.getSpacing().desktopGutterMini,
                        height: this.getSpacing().desktopDropDownMenuItemHeight,
                        lineHeight: this.getSpacing().desktopDropDownMenuItemHeight + 'px',
                        whiteSpace: 'nowrap'
                    },
                    rootWhenOpen: {
                        opacity: 1
                    },
                    labelWhenOpen: {
                        opacity: 0,
                        top: this.getSpacing().desktopToolbarHeight / 2
                    }
                };
                return styles;
            },

            render: function render() {
                var styles = this.getStyles();

                if (process.env.NODE_ENV !== 'production') {
                    console.assert(!!this.props.menuItems[this.state.selectedIndex], 'SelectedIndex of ' + this.state.selectedIndex + ' does not exist in menuItems.');
                }

                return React.createElement(
                    'div',
                    {
                        ref: 'root',
                        onMouseOut: this._handleMouseOut,
                        onMouseOver: this._handleMouseOver,
                        className: this.props.className,
                        style: this.mergeAndPrefix(styles.root, this.state.open && styles.rootWhenOpen, this.props.style) },
                    React.createElement(
                        ClearFix,
                        { style: this.mergeAndPrefix(styles.control), onTouchTap: this._onControlClick },
                        React.createElement(Paper, { style: this.mergeAndPrefix(styles.controlBg), zDepth: 0 }),
                        React.createElement(
                            'div',
                            { style: this.mergeAndPrefix(styles.label, this.state.open && styles.labelWhenOpen) },
                            this.props.menuItems[this.state.selectedIndex].text
                        ),
                        React.createElement(DropDownArrow, { style: this.mergeAndPrefix(styles.icon) }),
                        React.createElement('div', { style: this.mergeAndPrefix(styles.underline) })
                    ),
                    React.createElement(Menu, {
                        ref: 'menuItems',
                        autoWidth: this.props.autoWidth,
                        selectedIndex: this.state.selectedIndex,
                        menuItems: this.props.menuItems,
                        menuItemStyle: this.mergeAndPrefix(styles.menuItem, this.props.menuItemStyle),
                        hideable: true,
                        visible: this.state.open,
                        onItemTap: this._onMenuItemClick })
                );
            },

            _setWidth: function _setWidth() {
                var el = React.findDOMNode(this);
                var menuItemsDom = React.findDOMNode(this.refs.menuItems);
                if (!this.props.style || !this.props.style.hasOwnProperty('width')) {
                    el.style.width = menuItemsDom.offsetWidth + 'px';
                }
            },

            _setSelectedIndex: function _setSelectedIndex(props) {
                var selectedIndex = props.selectedIndex;

                if (process.env.NODE_ENV !== 'production' && selectedIndex < 0) {
                    console.warn('Cannot set selectedIndex to a negative index.', selectedIndex);
                }

                this.setState({ selectedIndex: selectedIndex > -1 ? selectedIndex : 0 });
            },

            _onControlClick: function _onControlClick() {
                this.setState({ open: !this.state.open });
            },

            _onMenuItemClick: function _onMenuItemClick(e, key, payload) {
                if (this.props.onChange && this.state.selectedIndex !== key) this.props.onChange(e, key, payload);
                this.setState({
                    selectedIndex: key,
                    open: false
                });
            },

            _handleMouseOver: function _handleMouseOver() {
                this.setState({ isHovered: true });
            },

            _handleMouseOut: function _handleMouseOut() {
                this.setState({ isHovered: false });
            }

        });

        module.exports = DropDownMenu;
    }).call(this,require('_process'))
},{"./clearfix":6,"./menu/menu":32,"./mixins/click-awayable":35,"./mixins/style-propable":36,"./paper":40,"./styles/transitions":55,"./svg-icons/drop-down-arrow":58,"_process":103,"react":"react"}],20:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var KeyCode = require('./utils/key-code');
    var StylePropable = require('./mixins/style-propable');
    var WindowListenable = require('./mixins/window-listenable');
    var FocusRipple = require('./ripples/focus-ripple');
    var TouchRipple = require('./ripples/touch-ripple');

    var EnhancedButton = React.createClass({
        displayName: 'EnhancedButton',

        mixins: [StylePropable, WindowListenable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            centerRipple: React.PropTypes.bool,
            className: React.PropTypes.string,
            disabled: React.PropTypes.bool,
            disableFocusRipple: React.PropTypes.bool,
            disableTouchRipple: React.PropTypes.bool,
            keyboardFocused: React.PropTypes.bool,
            linkButton: React.PropTypes.bool,
            focusRippleColor: React.PropTypes.string,
            touchRippleColor: React.PropTypes.string,
            focusRippleOpacity: React.PropTypes.number,
            touchRippleOpacity: React.PropTypes.number,
            onBlur: React.PropTypes.func,
            onFocus: React.PropTypes.func,
            onMouseOut: React.PropTypes.func,
            onMouseOver: React.PropTypes.func,
            onTouchTap: React.PropTypes.func,
            onKeyboardFocus: React.PropTypes.func },

        windowListeners: {
            'keydown': '_handleWindowKeydown',
            'keyup': '_handleWindowKeyup'
        },

        getInitialState: function getInitialState() {
            return {
                isKeyboardFocused: !this.props.disabled && this.props.keyboardFocused
            };
        },

        // Remove inner padding and border in Firefox 4+.
        componentDidMount: function componentDidMount() {
            if (!EnhancedButton.hasStyleBeenInjected) {
                var style = document.createElement('style');
                style.innerHTML = 'button::-moz-focus-inner,' + 'input::-moz-focus-inner {' + ' border: 0;' + ' padding: 0;' + ' }';
                document.body.appendChild(style);
                EnhancedButton.hasStyleBeenInjected = true;
            }
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    border: 10,
                    background: 'none',
                    boxSizing: 'border-box',
                    font: 'inherit',
                    fontFamily: this.context.muiTheme.contentFontFamily,
                    WebkitTapHighlightColor: 'rgba(0, 0, 0, 0)',
                    WebkitAppearance: !this.props.linkButton && 'button',
                    cursor: 'pointer'
                },
                rootWhenLinkButton: {
                    display: 'inline-block',
                    cursor: this.props.disabled ? 'default' : 'pointer',
                    textDecoration: 'none'
                },
                rootWhenDisabled: {
                    cursor: 'default'
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var centerRipple = _props.centerRipple;
            var disabled = _props.disabled;
            var disableFocusRipple = _props.disableFocusRipple;
            var disableTouchRipple = _props.disableTouchRipple;
            var linkButton = _props.linkButton;
            var touchRippleColor = _props.touchRippleColor;
            var onBlur = _props.onBlur;
            var onFocus = _props.onFocus;
            var onMouseOver = _props.onMouseOver;
            var onMouseOut = _props.onMouseOut;
            var onTouchTap = _props.onTouchTap;

            var other = _objectWithoutProperties(_props, ['centerRipple', 'disabled', 'disableFocusRipple', 'disableTouchRipple', 'linkButton', 'touchRippleColor', 'onBlur', 'onFocus', 'onMouseOver', 'onMouseOut', 'onTouchTap']);

            var styles = this.mergeAndPrefix(this.getStyles().root, this.props.linkButton && this.getStyles().rootWhenLinkButton, this.props.disabled && this.getStyles().rootWhenDisabled, this.props.style);
            var buttonChildren = [];

            // Create ripples if we need to
            buttonChildren.push(disabled || disableTouchRipple ? this.props.children : React.createElement(
                TouchRipple,
                {
                    ref: 'touchRipple',
                    key: 'touchRipple',
                    centerRipple: centerRipple,
                    color: this.props.touchRippleColor,
                    opacity: this.props.touchRippleOpacity },
                this.props.children
            ));
            buttonChildren.push(disabled || disableFocusRipple ? null : React.createElement(FocusRipple, {
                key: 'focusRipple',
                color: this.props.focusRippleColor,
                opacity: this.props.focusRippleOpacity,
                show: this.state.isKeyboardFocused }));

            var buttonProps = {
                style: styles,
                disabled: disabled,
                onBlur: this._handleBlur,
                onFocus: this._handleFocus,
                onMouseOver: this._handleMouseOver,
                onMouseOut: this._handleMouseOut,
                onTouchTap: this._handleTouchTap };

            if (disabled && linkButton) {
                return React.createElement(
                    'span',
                    _extends({}, other, {
                        className: this.props.className,
                        disabled: disabled }),
                    this.props.children
                );
            }

            return linkButton ? React.createElement(
                'a',
                _extends({}, other, buttonProps),
                buttonChildren
            ) : React.createElement(
                'button',
                _extends({}, other, buttonProps),
                buttonChildren
            );
        },

        isKeyboardFocused: function isKeyboardFocused() {
            return this.state.isKeyboardFocused;
        },

        _handleWindowKeydown: function _handleWindowKeydown(e) {
            if (!this.props.disabled) {
                if (e.keyCode == KeyCode.TAB) this._tabPressed = true;
                if (e.keyCode == KeyCode.ENTER && this.state.isKeyboardFocused) {
                    this._handleTouchTap(e);
                }
            }
        },

        _handleWindowKeyup: function _handleWindowKeyup(e) {
            if (!this.props.disabled && e.keyCode == KeyCode.SPACE && this.state.isKeyboardFocused) {
                this._handleTouchTap(e);
            }
        },

        _handleBlur: function _handleBlur(e) {
            this._cancelFocusTimeout();
            if (!this.props.disabled) {
                this.setState({
                    isKeyboardFocused: false
                });
                if (this.props.onKeyboardFocus) this.props.onKeyboardFocus(e, false);
                if (this.props.onBlur) this.props.onBlur(e);
            }
        },

        _handleFocus: function _handleFocus(e) {
            React.findDOMNode(this).style.outline = 'none';
            if (!this.props.disabled) {
                //setTimeout is needed because the focus event fires first
                //Wait so that we can capture if this was a keyboard focus
                //or touch focus
                this._focusTimeout = setTimeout((function () {
                    if (this._tabPressed) {
                        this.setState({
                            isKeyboardFocused: true
                        });
                        if (this.props.onKeyboardFocus) this.props.onKeyboardFocus(e, true);
                    }
                }).bind(this), 150);

                if (this.props.onFocus) this.props.onFocus(e);
            }
        },

        _handleMouseOver: function _handleMouseOver(e) {
            React.findDOMNode(this).style.textDecoration = 'none';
            if (this.props.onMouseOver) this.props.onMouseOver(e);
        },

        _handleMouseOut: function _handleMouseOut(e) {
            if (this.props.onMouseOut) this.props.onMouseOut(e);
        },

        _handleTouchTap: function _handleTouchTap(e) {
            this._cancelFocusTimeout();
            if (!this.props.disabled) {
                this._tabPressed = false;
                this.setState({
                    isKeyboardFocused: false
                });
                if (this.props.onKeyboardFocus) this.props.onKeyboardFocus(e, false);
                if (this.props.onTouchTap) this.props.onTouchTap(e);
            }
        },

        _cancelFocusTimeout: function _cancelFocusTimeout() {
            if (this._focusTimeout) {
                clearTimeout(this._focusTimeout);
                this._focusTimeout = null;
            }
        }

    });

    EnhancedButton.hasStyleBeenInjected = false;

    module.exports = EnhancedButton;
},{"./mixins/style-propable":36,"./mixins/window-listenable":38,"./ripples/focus-ripple":45,"./ripples/touch-ripple":46,"./utils/key-code":97,"react":"react"}],21:[function(require,module,exports){
    (function (process){
        'use strict';

        var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

        function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

        var React = require('react');
        var KeyCode = require('./utils/key-code');
        var StylePropable = require('./mixins/style-propable');
        var Transitions = require('./styles/transitions');
        var UniqueId = require('./utils/unique-id');
        var WindowListenable = require('./mixins/window-listenable');
        var Spacing = require('./styles/spacing');
        var ClearFix = require('./clearfix');
        var FocusRipple = require('./ripples/focus-ripple');
        var TouchRipple = require('./ripples/touch-ripple');
        var Paper = require('./paper');

        var EnhancedSwitch = React.createClass({
            displayName: 'EnhancedSwitch',

            mixins: [WindowListenable, StylePropable],

            contextTypes: {
                muiTheme: React.PropTypes.object
            },

            propTypes: {
                id: React.PropTypes.string,
                inputType: React.PropTypes.string.isRequired,
                switchElement: React.PropTypes.element.isRequired,
                onParentShouldUpdate: React.PropTypes.func.isRequired,
                switched: React.PropTypes.bool.isRequired,
                rippleStyle: React.PropTypes.object,
                rippleColor: React.PropTypes.string,
                iconStyle: React.PropTypes.object,
                thumbStyle: React.PropTypes.object,
                trackStyle: React.PropTypes.object,
                name: React.PropTypes.string,
                value: React.PropTypes.string,
                label: React.PropTypes.string,
                onSwitch: React.PropTypes.func,
                required: React.PropTypes.bool,
                disabled: React.PropTypes.bool,
                defaultSwitched: React.PropTypes.bool,
                labelPosition: React.PropTypes.oneOf(['left', 'right']),
                disableFocusRipple: React.PropTypes.bool,
                disableTouchRipple: React.PropTypes.bool
            },

            windowListeners: {
                'keydown': '_handleWindowKeydown',
                'keyup': '_handleWindowKeyup'
            },

            getInitialState: function getInitialState() {
                return {
                    isKeyboardFocused: false,
                    parentWidth: 100 };
            },

            getEvenWidth: function getEvenWidth() {
                return parseInt(window.getComputedStyle(React.findDOMNode(this.refs.root)).getPropertyValue('width'), 10);
            },

            componentDidMount: function componentDidMount() {
                var inputNode = React.findDOMNode(this.refs.checkbox);
                if (!this.props.switched || inputNode.checked != this.props.switched) this.props.onParentShouldUpdate(inputNode.checked);

                window.addEventListener('resize', this._handleResize);

                this._handleResize();
            },

            componentWillUnmount: function componentWillUnmount() {
                window.removeEventListener('resize', this._handleResize);
            },

            componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
                var hasCheckedLinkProp = nextProps.hasOwnProperty('checkedLink');
                var hasCheckedProp = nextProps.hasOwnProperty('checked');
                var hasToggledProp = nextProps.hasOwnProperty('toggled');
                var hasNewDefaultProp = nextProps.hasOwnProperty('defaultSwitched') && nextProps.defaultSwitched != this.props.defaultSwitched;
                var newState = {};

                if (hasCheckedProp) {
                    newState.switched = nextProps.checked;
                } else if (hasToggledProp) {
                    newState.switched = nextProps.toggled;
                } else if (hasCheckedLinkProp) {
                    newState.switched = nextProps.checkedLink.value;
                } else if (hasNewDefaultProp) {
                    newState.switched = nextProps.defaultSwitched;
                }

                if (newState.switched !== undefined && newState.switched != this.props.switched) this.props.onParentShouldUpdate(newState.switched);
            },

            getTheme: function getTheme() {
                return this.context.muiTheme.palette;
            },

            getStyles: function getStyles() {
                var switchWidth = 60 - Spacing.desktopGutterLess;
                var labelWidth = 'calc(100% - 60px)';

                var styles = {
                    root: {
                        position: 'relative',
                        cursor: this.props.disabled ? 'default' : 'pointer',
                        overflow: 'visible',
                        display: 'table',
                        height: 'auto',
                        width: '100%'
                    },
                    input: {
                        position: 'absolute',
                        cursor: this.props.disabled ? 'default' : 'pointer',
                        pointerEvents: 'all',
                        opacity: 0,
                        width: '100%',
                        height: '100%',
                        zIndex: 2,
                        left: 0,
                        boxSizing: 'border-box',
                        padding: 0,
                        margin: 0
                    },
                    controls: {
                        width: '100%',
                        height: '100%'
                    },
                    label: {
                        float: 'left',
                        position: 'relative',
                        display: 'table-column',
                        width: labelWidth,
                        lineHeight: '24px',
                        color: this.getTheme().textColor
                    },
                    wrap: {
                        transition: Transitions.easeOut(),
                        float: 'left',
                        position: 'relative',
                        display: 'table-column',
                        width: switchWidth,
                        marginRight: this.props.labelPosition == 'right' ? Spacing.desktopGutterLess : 0,
                        marginLeft: this.props.labelPosition == 'left' ? Spacing.desktopGutterLess : 0
                    },
                    ripple: {
                        height: '200%',
                        width: '200%',
                        top: '-12',
                        left: '-12'
                    }
                };
                return styles;
            },

            render: function render() {
                var _props = this.props;
                var type = _props.type;
                var name = _props.name;
                var value = _props.value;
                var label = _props.label;
                var onSwitch = _props.onSwitch;
                var defaultSwitched = _props.defaultSwitched;
                var onBlur = _props.onBlur;
                var onFocus = _props.onFocus;
                var onMouseUp = _props.onMouseUp;
                var onMouseDown = _props.onMouseDown;
                var onMouseOut = _props.onMouseOut;
                var onTouchStart = _props.onTouchStart;
                var onTouchEnd = _props.onTouchEnd;
                var disableTouchRipple = _props.disableTouchRipple;
                var disableFocusRipple = _props.disableFocusRipple;
                var className = _props.className;

                var other = _objectWithoutProperties(_props, ['type', 'name', 'value', 'label', 'onSwitch', 'defaultSwitched', 'onBlur', 'onFocus', 'onMouseUp', 'onMouseDown', 'onMouseOut', 'onTouchStart', 'onTouchEnd', 'disableTouchRipple', 'disableFocusRipple', 'className']);

                var styles = this.getStyles();

                styles.root.cursor = styles.root.input = this.props.disabled ? 'default' : 'pointer';

                var wrapStyles = this.mergeAndPrefix(styles.wrap, this.props.iconStyle);
                var rippleStyle = this.mergeAndPrefix(styles.ripple, this.props.rippleStyle);
                var rippleColor = this.props.hasOwnProperty('rippleColor') ? this.props.rippleColor : this.getTheme().primary1Color;

                if (this.props.thumbStyle) {
                    wrapStyles.marginLeft /= 2;
                    wrapStyles.marginRight /= 2;
                }

                var inputId = this.props.id || UniqueId.generate();

                var labelElement = this.props.label ? React.createElement(
                    'label',
                    { style: this.mergeAndPrefix(styles.label), htmlFor: inputId },
                    this.props.label
                ) : null;

                var inputProps = {
                    ref: 'checkbox',
                    type: this.props.inputType,
                    style: this.mergeAndPrefix(styles.input),
                    name: this.props.name,
                    value: this.props.value,
                    defaultChecked: this.props.defaultSwitched,
                    onBlur: this._handleBlur,
                    onFocus: this._handleFocus
                };

                var hideTouchRipple = this.props.disabled || disableTouchRipple;

                if (!hideTouchRipple) {
                    inputProps.onMouseUp = this._handleMouseUp;
                    inputProps.onMouseDown = this._handleMouseDown;
                    inputProps.onMouseOut = this._handleMouseOut;
                    inputProps.onTouchStart = this._handleTouchStart;
                    inputProps.onTouchEnd = this._handleTouchEnd;
                }

                if (!this.props.hasOwnProperty('checkedLink')) {
                    inputProps.onChange = this._handleChange;
                }

                var inputElement = React.createElement('input', _extends({}, other, inputProps));

                var touchRipple = React.createElement(TouchRipple, {
                    ref: 'touchRipple',
                    key: 'touchRipple',
                    style: rippleStyle,
                    color: rippleColor,
                    centerRipple: true });

                var focusRipple = React.createElement(FocusRipple, {
                    key: 'focusRipple',
                    innerStyle: rippleStyle,
                    color: rippleColor,
                    show: this.state.isKeyboardFocused });

                var ripples = [hideTouchRipple ? null : touchRipple, this.props.disabled || disableFocusRipple ? null : focusRipple];

                // If toggle component (indicated by whether the style includes thumb) manually lay out
                // elements in order to nest ripple elements
                var switchElement = !this.props.thumbStyle ? React.createElement(
                    'div',
                    { style: wrapStyles },
                    this.props.switchElement,
                    ripples
                ) : React.createElement(
                    'div',
                    { style: wrapStyles },
                    React.createElement('div', { style: this.props.trackStyle }),
                    React.createElement(
                        Paper,
                        { style: this.props.thumbStyle, zDepth: 1, circle: true },
                        ' ',
                        ripples,
                        ' '
                    )
                );

                var labelPositionExist = this.props.labelPosition;

                // Position is left if not defined or invalid.
                var elementsInOrder = labelPositionExist && this.props.labelPosition.toUpperCase() === 'RIGHT' ? React.createElement(
                    ClearFix,
                    { style: this.mergeAndPrefix(styles.controls) },
                    switchElement,
                    labelElement
                ) : React.createElement(
                    ClearFix,
                    { style: this.mergeAndPrefix(styles.controls) },
                    labelElement,
                    switchElement
                );

                return React.createElement(
                    'div',
                    { ref: 'root', className: className, style: this.mergeAndPrefix(styles.root, this.props.style) },
                    inputElement,
                    elementsInOrder
                );
            },

            isSwitched: function isSwitched() {
                return React.findDOMNode(this.refs.checkbox).checked;
            },

            // no callback here because there is no event
            setSwitched: function setSwitched(newSwitchedValue) {
                if (!this.props.hasOwnProperty('checked') || this.props.checked === false) {
                    this.props.onParentShouldUpdate(newSwitchedValue);
                    React.findDOMNode(this.refs.checkbox).checked = newSwitchedValue;
                } else if (process.env.NODE_ENV !== 'production') {
                    var message = 'Cannot call set method while checked is defined as a property.';
                    console.error(message);
                }
            },

            getValue: function getValue() {
                return React.findDOMNode(this.refs.checkbox).value;
            },

            isKeyboardFocused: function isKeyboardFocused() {
                return this.state.isKeyboardFocused;
            },

            _handleChange: function _handleChange(e) {
                this._tabPressed = false;
                this.setState({
                    isKeyboardFocused: false
                });

                var isInputChecked = React.findDOMNode(this.refs.checkbox).checked;

                if (!this.props.hasOwnProperty('checked')) this.props.onParentShouldUpdate(isInputChecked);
                if (this.props.onSwitch) this.props.onSwitch(e, isInputChecked);
            },

            /**
             * Because both the ripples and the checkbox input cannot share pointer
             * events, the checkbox input takes control of pointer events and calls
             * ripple animations manually.
             */

            // Checkbox inputs only use SPACE to change their state. Using ENTER will
            // update the ui but not the input.
            _handleWindowKeydown: function _handleWindowKeydown(e) {
                if (e.keyCode == KeyCode.TAB) this._tabPressed = true;
                if (e.keyCode == KeyCode.SPACE && this.state.isKeyboardFocused) {
                    this._handleChange(e);
                }
            },

            _handleWindowKeyup: function _handleWindowKeyup(e) {
                if (e.keyCode == KeyCode.SPACE && this.state.isKeyboardFocused) {
                    this._handleChange(e);
                }
            },

            _handleMouseDown: function _handleMouseDown(e) {
                //only listen to left clicks
                if (e.button === 0) this.refs.touchRipple.start(e);
            },

            _handleMouseUp: function _handleMouseUp() {
                this.refs.touchRipple.end();
            },

            _handleMouseOut: function _handleMouseOut() {
                this.refs.touchRipple.end();
            },

            _handleTouchStart: function _handleTouchStart(e) {
                this.refs.touchRipple.start(e);
            },

            _handleTouchEnd: function _handleTouchEnd() {
                this.refs.touchRipple.end();
            },

            _handleBlur: function _handleBlur(e) {
                this.setState({
                    isKeyboardFocused: false
                });

                if (this.props.onBlur) this.props.onBlur(e);
            },

            _handleFocus: function _handleFocus(e) {
                //setTimeout is needed becuase the focus event fires first
                //Wait so that we can capture if this was a keyboard focus
                //or touch focus
                setTimeout((function () {
                    if (this._tabPressed) {
                        this.setState({
                            isKeyboardFocused: true
                        });
                    }
                }).bind(this), 150);

                if (this.props.onFocus) this.props.onFocus(e);
            },

            _handleResize: function _handleResize() {
                this.setState({ parentWidth: this.getEvenWidth() });
            }

        });

        module.exports = EnhancedSwitch;
    }).call(this,require('_process'))
},{"./clearfix":6,"./mixins/style-propable":36,"./mixins/window-listenable":38,"./paper":40,"./ripples/focus-ripple":45,"./ripples/touch-ripple":46,"./styles/spacing":51,"./styles/transitions":55,"./utils/key-code":97,"./utils/unique-id":100,"_process":103,"react":"react"}],22:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var AutoPrefix = require('./styles/auto-prefix');

    var EnhancedTextarea = React.createClass({
        displayName: 'EnhancedTextarea',

        mixins: [StylePropable],

        propTypes: {
            onChange: React.PropTypes.func,
            onHeightChange: React.PropTypes.func,
            textareaStyle: React.PropTypes.object,
            rows: React.PropTypes.number
        },

        getDefaultProps: function getDefaultProps() {
            return {
                rows: 1
            };
        },

        getInitialState: function getInitialState() {
            return {
                height: this.props.rows * 24
            };
        },

        componentDidMount: function componentDidMount() {
            this._syncHeightWithShadow();
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    width: '100%',
                    resize: 'none',
                    overflow: 'hidden',
                    font: 'inherit',
                    padding: 0 }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var onChange = _props.onChange;
            var onHeightChange = _props.onHeightChange;
            var rows = _props.rows;
            var style = _props.style;
            var textareaStyle = _props.textareaStyle;
            var valueLink = _props.valueLink;

            var other = _objectWithoutProperties(_props, ['onChange', 'onHeightChange', 'rows', 'style', 'textareaStyle', 'valueLink']);

            var styles = this.getStyles().root;

            var textAreaStyles = {
                width: '100%',
                resize: 'none',
                overflow: 'hidden',
                font: 'inherit',
                padding: 0 };

            var inputStyles = this.mergeAndPrefix(styles, {
                height: this.state.height + 'px' });

            inputStyles = this.mergeAndPrefix(inputStyles, textareaStyle);

            // Overflow also needed to here to remove the extra row
            // added to textareas in Firefox.
            var shadowStyles = this.mergeAndPrefix(textAreaStyles, {
                position: 'absolute',
                opacity: 0
            });

            if (this.props.hasOwnProperty('valueLink')) other.value = this.props.valueLink.value;
            if (this.props.disabled) style.cursor = 'default';

            return React.createElement(
                'div',
                { style: this.props.style },
                React.createElement('textarea', {
                    ref: 'shadow',
                    style: AutoPrefix.all(shadowStyles),
                    tabIndex: '-1',
                    rows: this.props.rows,
                    defaultValue: this.props.defaultValue,
                    readOnly: true,
                    value: this.props.value,
                    valueLink: this.props.valueLink }),
                React.createElement('textarea', _extends({}, other, {
                    ref: 'input',
                    rows: this.props.rows,
                    style: AutoPrefix.all(inputStyles),
                    onChange: this._handleChange }))
            );
        },

        getInputNode: function getInputNode() {
            return React.findDOMNode(this.refs.input);
        },

        _syncHeightWithShadow: function _syncHeightWithShadow(newValue, e) {
            var shadow = React.findDOMNode(this.refs.shadow);
            var currentHeight = this.state.height;
            var newHeight;

            if (newValue !== undefined) shadow.value = newValue;
            newHeight = shadow.scrollHeight;

            if (currentHeight !== newHeight) {
                this.setState({ height: newHeight });
                if (this.props.onHeightChange) this.props.onHeightChange(e, newHeight);
            }
        },

        _handleChange: function _handleChange(e) {
            this._syncHeightWithShadow(e.target.value);

            if (this.props.hasOwnProperty('valueLink')) {
                this.props.valueLink.requestChange(e.target.value);
            }

            if (this.props.onChange) this.props.onChange(e);
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            if (nextProps.value != this.props.value) {
                this._syncHeightWithShadow(nextProps.value);
            }
        }
    });

    module.exports = EnhancedTextarea;
},{"./mixins/style-propable":36,"./styles/auto-prefix":49,"react":"react"}],23:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var ColorManipulator = require('./utils/color-manipulator');
    var Typography = require('./styles/typography');
    var EnhancedButton = require('./enhanced-button');

    var FlatButton = React.createClass({
        displayName: 'FlatButton',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            disabled: React.PropTypes.bool,
            hoverColor: React.PropTypes.string,
            label: function label(props, propName, componentName) {
                if (!props.children && !props.label) {
                    return new Error('Warning: Required prop `label` or `children` was not specified in `' + componentName + '`.');
                }
            },
            labelStyle: React.PropTypes.object,
            primary: React.PropTypes.bool,
            rippleColor: React.PropTypes.string,
            secondary: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                labelStyle: {} };
        },

        getInitialState: function getInitialState() {
            return {
                hovered: false,
                isKeyboardFocused: false
            };
        },

        getThemeButton: function getThemeButton() {
            return this.context.muiTheme.component.button;
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.flatButton;
        },

        _getColor: function _getColor() {
            var theme = this.getTheme();
            var color = this.props.disabled ? theme.disabledTextColor : this.props.primary ? theme.primaryTextColor : this.props.secondary ? theme.secondaryTextColor : theme.textColor;

            return {
                'default': color,
                hover: this.props.hoverColor || ColorManipulator.fade(ColorManipulator.lighten(color, 0.4), 0.15),
                ripple: this.props.rippleColor || ColorManipulator.fade(color, 0.8)
            };
        },

        getStyles: function getStyles() {
            var color = this._getColor();
            var styles = {
                root: {
                    color: color['default'],
                    transition: Transitions.easeOut(),
                    fontSize: Typography.fontStyleButtonFontSize,
                    letterSpacing: 0,
                    textTransform: 'uppercase',
                    fontWeight: Typography.fontWeightMedium,
                    borderRadius: 2,
                    userSelect: 'none',
                    position: 'relative',
                    overflow: 'hidden',
                    backgroundColor: this.getTheme().color,
                    lineHeight: this.getThemeButton().height + 'px',
                    minWidth: this.getThemeButton().minWidth,
                    padding: 0,
                    margin: 0,
                    //This is need so that ripples do not bleed past border radius.
                    //See: http://stackoverflow.com/questions/17298739/css-overflow-hidden-not-working-in-chrome-when-parent-has-border-radius-and-chil
                    transform: 'translate3d(0, 0, 0)' },
                label: {
                    position: 'relative',
                    padding: '0px ' + this.context.muiTheme.spacing.desktopGutterLess + 'px' },
                rootWhenHovered: {
                    backgroundColor: color.hover
                },
                rippleColor: color.ripple
            };

            return styles;
        },

        render: function render() {
            var _props = this.props;
            var children = _props.children;
            var hoverColor = _props.hoverColor;
            var label = _props.label;
            var labelStyle = _props.labelStyle;
            var onBlur = _props.onBlur;
            var onMouseOut = _props.onMouseOut;
            var onMouseOver = _props.onMouseOver;
            var primary = _props.primary;
            var rippleColor = _props.rippleColor;
            var secondary = _props.secondary;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['children', 'hoverColor', 'label', 'labelStyle', 'onBlur', 'onMouseOut', 'onMouseOver', 'primary', 'rippleColor', 'secondary', 'style']);

            var styles = this.getStyles();

            var labelElement;
            if (label) {
                labelElement = React.createElement(
                    'span',
                    { style: this.mergeAndPrefix(styles.label, this.props.labelStyle) },
                    label
                );
            }

            return React.createElement(
                EnhancedButton,
                _extends({}, other, {
                    ref: 'enhancedButton',
                    style: this.mergeStyles(styles.root, (this.state.hovered || this.state.isKeyboardFocused) && !this.props.disabled && styles.rootWhenHovered, this.props.style),
                    onMouseOver: this._handleMouseOver,
                    onMouseOut: this._handleMouseOut,
                    focusRippleColor: styles.rippleColor,
                    touchRippleColor: styles.rippleColor,
                    onKeyboardFocus: this._handleKeyboardFocus }),
                labelElement,
                this.props.children
            );
        },

        _handleMouseOver: function _handleMouseOver(e) {
            this.setState({ hovered: true });
            if (this.props.onMouseOver) {
                this.props.onMouseOver(e);
            }
        },

        _handleMouseOut: function _handleMouseOut(e) {
            this.setState({ hovered: false });
            if (this.props.onMouseOut) {
                this.props.onMouseOut(e);
            }
        },

        _handleKeyboardFocus: function _handleKeyboardFocus(e, isKeyboardFocused) {
            this.setState({ isKeyboardFocused: isKeyboardFocused });
        },

        _handleOnBlur: function _handleOnBlur(e) {
            this.setState({ hovered: false });
            if (this.props.onBlur) {
                this.props.onBlur(e);
            }
        }
    });

    module.exports = FlatButton;
},{"./enhanced-button":20,"./mixins/style-propable":36,"./styles/transitions":55,"./styles/typography":56,"./utils/color-manipulator":91,"react":"react"}],24:[function(require,module,exports){
    (function (process){
        'use strict';

        var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

        function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

        var React = require('react');
        var StylePropable = require('./mixins/style-propable');
        var Transitions = require('./styles/transitions');
        var ColorManipulator = require('./utils/color-manipulator');
        var EnhancedButton = require('./enhanced-button');
        var FontIcon = require('./font-icon');
        var Paper = require('./paper');

        var getZDepth = function getZDepth(disabled) {
            var zDepth = disabled ? 0 : 2;
            return {
                zDepth: zDepth,
                initialZDepth: zDepth
            };
        };

        var RaisedButton = React.createClass({
            displayName: 'RaisedButton',

            mixins: [StylePropable],

            contextTypes: {
                muiTheme: React.PropTypes.object
            },

            propTypes: {
                iconClassName: React.PropTypes.string,
                iconStyle: React.PropTypes.object,
                mini: React.PropTypes.bool,
                onMouseDown: React.PropTypes.func,
                onMouseUp: React.PropTypes.func,
                onMouseOut: React.PropTypes.func,
                onTouchEnd: React.PropTypes.func,
                onTouchStart: React.PropTypes.func,
                secondary: React.PropTypes.bool
            },

            getInitialState: function getInitialState() {
                var zDepth = this.props.disabled ? 0 : 2;
                return {
                    zDepth: zDepth,
                    initialZDepth: zDepth,
                    hovered: false };
            },

            componentWillMount: function componentWillMount() {
                this.setState(getZDepth(this.props.disabled));
            },

            componentWillReceiveProps: function componentWillReceiveProps(newProps) {
                if (newProps.disabled !== this.props.disabled) {
                    this.setState(getZDepth(newProps.disabled));
                }
            },

            componentDidMount: function componentDidMount() {
                if (process.env.NODE_ENV !== 'production') {
                    if (this.props.iconClassName && this.props.children) {
                        var warning = 'You have set both an iconClassName and a child icon. ' + 'It is recommended you use only one method when adding ' + 'icons to FloatingActionButtons.';
                        console.warn(warning);
                    }
                }
            },

            _getBackgroundColor: function _getBackgroundColor() {
                return this.props.disabled ? this.getTheme().disabledColor : this.props.secondary ? this.getTheme().secondaryColor : this.getTheme().color;
            },

            getTheme: function getTheme() {
                return this.context.muiTheme.component.floatingActionButton;
            },

            _getIconColor: function _getIconColor() {
                return this.props.disabled ? this.getTheme().disabledTextColor : this.props.secondary ? this.getTheme().secondaryIconColor : this.getTheme().iconColor;
            },

            getStyles: function getStyles() {
                var styles = {
                    root: {
                        transition: Transitions.easeOut(),
                        display: 'inline-block'
                    },
                    container: {
                        transition: Transitions.easeOut(),
                        position: 'relative',
                        height: this.getTheme().buttonSize,
                        width: this.getTheme().buttonSize,
                        padding: 0,
                        overflow: 'hidden',
                        backgroundColor: this._getBackgroundColor(),
                        borderRadius: '50%',
                        textAlign: 'center',
                        verticalAlign: 'bottom',
                        //This is need so that ripples do not bleed
                        //past border radius.
                        //See: http://stackoverflow.com/questions/17298739/css-overflow-hidden-not-working-in-chrome-when-parent-has-border-radius-and-chil
                        transform: 'translate3d(0, 0, 0)'
                    },
                    icon: {
                        lineHeight: this.getTheme().buttonSize + 'px',
                        fill: this.getTheme().iconColor,
                        color: this._getIconColor()
                    },
                    overlay: {
                        transition: Transitions.easeOut(),
                        top: 0
                    },
                    containerWhenMini: {
                        height: this.getTheme().miniSize,
                        width: this.getTheme().miniSize
                    },
                    iconWhenMini: {
                        lineHeight: this.getTheme().miniSize + 'px'
                    },
                    overlayWhenHovered: {
                        backgroundColor: ColorManipulator.fade(this._getIconColor(), 0.4)
                    }
                };
                return styles;
            },

            render: function render() {
                var _props = this.props;
                var icon = _props.icon;
                var mini = _props.mini;
                var secondary = _props.secondary;

                var other = _objectWithoutProperties(_props, ['icon', 'mini', 'secondary']);

                var styles = this.getStyles();

                var iconElement;
                if (this.props.iconClassName) {
                    iconElement = React.createElement(FontIcon, {
                        className: this.props.iconClassName,
                        style: this.mergeAndPrefix(styles.icon, this.props.mini && styles.iconWhenMini, this.props.iconStyle) });
                }

                var rippleColor = styles.icon.color;

                return React.createElement(
                    Paper,
                    {
                        style: this.mergeAndPrefix(styles.root, this.props.style),
                        zDepth: this.state.zDepth,
                        circle: true },
                    React.createElement(
                        EnhancedButton,
                        _extends({}, other, {
                            ref: 'container',
                            style: this.mergeAndPrefix(styles.container, this.props.mini && styles.containerWhenMini),
                            onMouseDown: this._handleMouseDown,
                            onMouseUp: this._handleMouseUp,
                            onMouseOut: this._handleMouseOut,
                            onMouseOver: this._handleMouseOver,
                            onTouchStart: this._handleTouchStart,
                            onTouchEnd: this._handleTouchEnd,
                            focusRippleColor: rippleColor,
                            touchRippleColor: rippleColor,
                            onKeyboardFocus: this._handleKeyboardFocus }),
                        React.createElement(
                            'div',
                            {
                                ref: 'overlay',
                                style: this.mergeAndPrefix(styles.overlay, this.state.hovered && !this.props.disabled && styles.overlayWhenHovered) },
                            iconElement,
                            this.props.children
                        )
                    )
                );
            },

            _handleMouseDown: function _handleMouseDown(e) {
                //only listen to left clicks
                if (e.button === 0) {
                    this.setState({ zDepth: this.state.initialZDepth + 1 });
                }
                if (this.props.onMouseDown) this.props.onMouseDown(e);
            },

            _handleMouseUp: function _handleMouseUp(e) {
                this.setState({ zDepth: this.state.initialZDepth });
                if (this.props.onMouseUp) this.props.onMouseUp(e);
            },

            _handleMouseOut: function _handleMouseOut(e) {
                if (!this.refs.container.isKeyboardFocused()) this.setState({ zDepth: this.state.initialZDepth, hovered: false });
                if (this.props.onMouseOut) this.props.onMouseOut(e);
            },

            _handleMouseOver: function _handleMouseOver(e) {
                if (!this.refs.container.isKeyboardFocused()) this.setState({ hovered: true });
                if (this.props.onMouseOver) this.props.onMouseOver(e);
            },

            _handleTouchStart: function _handleTouchStart(e) {
                this.setState({ zDepth: this.state.initialZDepth + 1 });
                if (this.props.onTouchStart) this.props.onTouchStart(e);
            },

            _handleTouchEnd: function _handleTouchEnd(e) {
                this.setState({ zDepth: this.state.initialZDepth });
                if (this.props.onTouchEnd) this.props.onTouchEnd(e);
            },

            _handleKeyboardFocus: function _handleKeyboardFocus(e, keyboardFocused) {
                if (keyboardFocused && !this.props.disabled) {
                    this.setState({ zDepth: this.state.initialZDepth + 1 });
                    React.findDOMNode(this.refs.overlay).style.backgroundColor = ColorManipulator.fade(this.getStyles().icon.color, 0.4);
                } else if (!this.state.hovered) {
                    this.setState({ zDepth: this.state.initialZDepth });
                    React.findDOMNode(this.refs.overlay).style.backgroundColor = 'transparent';
                }
            } });

        module.exports = RaisedButton;
    }).call(this,require('_process'))
},{"./enhanced-button":20,"./font-icon":25,"./mixins/style-propable":36,"./paper":40,"./styles/transitions":55,"./utils/color-manipulator":91,"_process":103,"react":"react"}],25:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Spacing = require('./styles/spacing');
    var Transitions = require('./styles/transitions');

    var FontIcon = React.createClass({
        displayName: 'FontIcon',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            hoverColor: React.PropTypes.string
        },

        getInitialState: function getInitialState() {
            return {
                hovered: false };
        },

        getStyles: function getStyles() {
            var theme = this.context.muiTheme.palette;
            var styles = {
                position: 'relative',
                fontSize: Spacing.iconSize + 'px',
                display: 'inline-block',
                userSelect: 'none',
                transition: Transitions.easeOut()
            };

            if (!styles.color && !this.props.className) {
                styles.color = theme.textColor;
            }

            return styles;
        },

        render: function render() {
            var _props = this.props;
            var onMouseOut = _props.onMouseOut;
            var onMouseOver = _props.onMouseOver;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['onMouseOut', 'onMouseOver', 'style']);

            var hoverStyle = this.props.hoverColor ? { color: this.props.hoverColor } : {};

            return React.createElement('span', _extends({}, other, {
                onMouseOut: this._handleMouseOut,
                onMouseOver: this._handleMouseOver,
                style: this.mergeAndPrefix(this.getStyles(), this.props.style, this.state.hovered && hoverStyle) }));
        },

        _handleMouseOut: function _handleMouseOut(e) {
            this.setState({ hovered: false });
            if (this.props.onMouseOut) {
                this.props.onMouseOut(e);
            }
        },

        _handleMouseOver: function _handleMouseOver(e) {
            this.setState({ hovered: true });
            if (this.props.onMouseOver) {
                this.props.onMouseOver(e);
            }
        }
    });

    module.exports = FontIcon;
},{"./mixins/style-propable":36,"./styles/spacing":51,"./styles/transitions":55,"react":"react"}],26:[function(require,module,exports){
    (function (process){
        'use strict';

        var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

        function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

        var React = require('react');
        var StylePropable = require('./mixins/style-propable');
        var Transitions = require('./styles/transitions');
        var EnhancedButton = require('./enhanced-button');
        var FontIcon = require('./font-icon');
        var Tooltip = require('./tooltip');

        var IconButton = React.createClass({
            displayName: 'IconButton',

            mixins: [StylePropable],

            contextTypes: {
                muiTheme: React.PropTypes.object
            },

            propTypes: {
                className: React.PropTypes.string,
                disabled: React.PropTypes.bool,
                iconClassName: React.PropTypes.string,
                iconStyle: React.PropTypes.object,
                onBlur: React.PropTypes.func,
                onFocus: React.PropTypes.func,
                tooltip: React.PropTypes.string,
                touch: React.PropTypes.bool },

            getInitialState: function getInitialState() {
                return {
                    tooltipShown: false
                };
            },

            getDefaultProps: function getDefaultProps() {
                return {
                    iconStyle: {}
                };
            },

            componentDidMount: function componentDidMount() {
                if (this.props.tooltip) {
                    this._positionTooltip();
                }
                if (process.env.NODE_ENV !== 'production') {
                    if (this.props.iconClassName && this.props.children) {
                        var warning = 'You have set both an iconClassName and a child icon. ' + 'It is recommended you use only one method when adding ' + 'icons to IconButtons.';
                        console.warn(warning);
                    }
                }
            },

            getTheme: function getTheme() {
                return this.context.muiTheme.palette;
            },

            getSpacing: function getSpacing() {
                return this.context.muiTheme.spacing;
            },

            getDisabledColor: function getDisabledColor() {
                return this.context.muiTheme.palette.disabledColor;
            },

            getStyles: function getStyles() {
                var styles = {
                    root: {
                        position: 'relative',
                        boxSizing: 'border-box',
                        transition: Transitions.easeOut(),
                        padding: this.getSpacing().iconSize / 2,
                        width: this.getSpacing().iconSize * 2,
                        height: this.getSpacing().iconSize * 2
                    },
                    tooltip: {
                        boxSizing: 'border-box',
                        marginTop: this.context.muiTheme.component.button.iconButtonSize + 4
                    },
                    icon: {
                        color: this.getTheme().textColor,
                        fill: this.getTheme().textColor
                    },
                    overlay: {
                        position: 'relative',
                        top: 0,
                        width: '100%',
                        height: '100%',
                        background: this.getDisabledColor()
                    },
                    rootWhenDisabled: {
                        color: this.getDisabledColor(),
                        fill: this.getDisabledColor()
                    },
                    iconWhenDisabled: {
                        color: this.getDisabledColor(),
                        fill: this.getDisabledColor()
                    }
                };
                return styles;
            },

            render: function render() {
                var _props = this.props;
                var tooltip = _props.tooltip;
                var touch = _props.touch;

                var other = _objectWithoutProperties(_props, ['tooltip', 'touch']);

                var tooltipElement;
                var fonticon;

                var styles = this.getStyles();

                if (tooltip) {
                    tooltipElement = React.createElement(Tooltip, {
                        ref: 'tooltip',
                        label: tooltip,
                        show: this.state.tooltipShown,
                        touch: touch,
                        style: this.mergeStyles(styles.tooltip) });
                }

                if (this.props.iconClassName) {
                    var _props$iconStyle = this.props.iconStyle;
                    var iconHoverColor = _props$iconStyle.iconHoverColor;

                    var iconStyle = _objectWithoutProperties(_props$iconStyle, ['iconHoverColor']);

                    fonticon = React.createElement(FontIcon, {
                        className: this.props.iconClassName,
                        hoverColor: iconHoverColor,
                        style: this.mergeStyles(styles.icon, this.props.disabled && styles.iconWhenDisabled, iconStyle) });
                }

                if (this.props.children && this.props.disabled) {
                    React.Children.forEach(this.props.children, function (child) {
                        child.props.style = {
                            color: this.getDisabledColor(),
                            fill: this.getDisabledColor() };
                    }, this);
                }

                return React.createElement(
                    EnhancedButton,
                    _extends({}, other, {
                        ref: 'button',
                        centerRipple: true,
                        style: this.mergeStyles(styles.root, this.props.style),
                        onBlur: this._handleBlur,
                        onFocus: this._handleFocus,
                        onMouseOut: this._handleMouseOut,
                        onMouseOver: this._handleMouseOver,
                        onKeyboardFocus: this._handleKeyboardFocus }),
                    tooltipElement,
                    fonticon,
                    this.props.children
                );
            },

            _positionTooltip: function _positionTooltip() {
                var tooltip = React.findDOMNode(this.refs.tooltip);
                var tooltipWidth = tooltip.offsetWidth;
                var buttonWidth = 48;

                tooltip.style.left = (tooltipWidth - buttonWidth) / 2 * -1 + 'px';
            },

            _showTooltip: function _showTooltip() {
                if (!this.props.disabled && this.props.tooltip) {
                    this.setState({ tooltipShown: true });
                }
            },

            _hideTooltip: function _hideTooltip() {
                if (this.props.tooltip) this.setState({ tooltipShown: false });
            },

            _handleBlur: function _handleBlur(e) {
                this._hideTooltip();
                if (this.props.onBlur) this.props.onBlur(e);
            },

            _handleFocus: function _handleFocus(e) {
                this._showTooltip();
                if (this.props.onFocus) this.props.onFocus(e);
            },

            _handleMouseOut: function _handleMouseOut(e) {
                if (!this.refs.button.isKeyboardFocused()) this._hideTooltip();
                if (this.props.onMouseOut) this.props.onMouseOut(e);
            },

            _handleMouseOver: function _handleMouseOver(e) {
                this._showTooltip();
                if (this.props.onMouseOver) this.props.onMouseOver(e);
            },

            _handleKeyboardFocus: function _handleKeyboardFocus(e, keyboardFocused) {
                if (keyboardFocused && !this.props.disabled) {
                    this._showTooltip();
                    if (this.props.onFocus) this.props.onFocus(e);
                } else if (!this.state.hovered) {
                    this._hideTooltip();
                    if (this.props.onBlur) this.props.onBlur(e);
                }
            }

        });

        module.exports = IconButton;
    }).call(this,require('_process'))
},{"./enhanced-button":20,"./font-icon":25,"./mixins/style-propable":36,"./styles/transitions":55,"./tooltip":88,"_process":103,"react":"react"}],27:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var Transitions = require('./styles/transitions');
    var StylePropable = require('./mixins/style-propable');

    var InkBar = React.createClass({
        displayName: 'InkBar',

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            left: React.PropTypes.string.isRequired,
            width: React.PropTypes.string.isRequired },

        mixins: [StylePropable],

        render: function render() {
            var palette = this.context.muiTheme.palette;

            var styles = this.mergeAndPrefix({
                left: this.props.left,
                width: this.props.width,
                bottom: 0,
                display: 'block',
                backgroundColor: palette.accent1Color,
                height: 2,
                marginTop: -2,
                position: 'relative',
                transition: Transitions.easeOut('1s', 'left')
            });

            return React.createElement(
                'div',
                { style: styles },
                ' '
            );
        }

    });

    module.exports = InkBar;
},{"./mixins/style-propable":36,"./styles/transitions":55,"react":"react"}],28:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var KeyCode = require('./utils/key-code');
    var StylePropable = require('./mixins/style-propable');
    var AutoPrefix = require('./styles/auto-prefix');
    var Transitions = require('./styles/transitions');
    var WindowListenable = require('./mixins/window-listenable');
    var Overlay = require('./overlay');
    var Paper = require('./paper');
    var Menu = require('./menu/menu');

    var LeftNav = React.createClass({
        displayName: 'LeftNav',

        mixins: [StylePropable, WindowListenable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            docked: React.PropTypes.bool,
            header: React.PropTypes.element,
            menuItems: React.PropTypes.array.isRequired,
            onChange: React.PropTypes.func,
            onNavOpen: React.PropTypes.func,
            onNavClose: React.PropTypes.func,
            openRight: React.PropTypes.bool,
            selectedIndex: React.PropTypes.number
        },

        windowListeners: {
            'keyup': '_onWindowKeyUp',
            'resize': '_onWindowResize'
        },

        getDefaultProps: function getDefaultProps() {
            return {
                docked: true
            };
        },

        getInitialState: function getInitialState() {
            return {
                open: this.props.docked,
                maybeSwiping: false,
                swiping: false
            };
        },

        componentDidMount: function componentDidMount() {
            this._updateMenuHeight();
            this._enableSwipeHandling();
        },

        componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
            this._updateMenuHeight();
            this._enableSwipeHandling();
        },

        componentWillUnmount: function componentWillUnmount() {
            this._disableSwipeHandling();
        },

        toggle: function toggle() {
            this.setState({ open: !this.state.open });
            return this;
        },

        close: function close() {
            this.setState({ open: false });
            if (this.props.onNavClose) this.props.onNavClose();
            return this;
        },

        open: function open() {
            this.setState({ open: true });
            if (this.props.onNavOpen) this.props.onNavOpen();
            return this;
        },

        getThemePalette: function getThemePalette() {
            return this.context.muiTheme.palette;
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.leftNav;
        },

        getStyles: function getStyles() {
            var x = this._getTranslateMultiplier() * (this.state.open ? 0 : this._getMaxTranslateX()) + 'px';
            var styles = {
                root: {
                    height: '100%',
                    width: this.getTheme().width,
                    position: 'fixed',
                    zIndex: 10,
                    left: 0,
                    top: 0,
                    transform: 'translate3d(' + x + ', 0, 0)',
                    transition: !this.state.swiping && Transitions.easeOut(),
                    backgroundColor: this.getTheme().color,
                    overflow: 'hidden'
                },
                menu: {
                    overflowY: 'auto',
                    overflowX: 'hidden',
                    height: '100%'
                },
                menuItem: {
                    height: this.context.muiTheme.spacing.desktopLeftNavMenuItemHeight,
                    lineHeight: this.context.muiTheme.spacing.desktopLeftNavMenuItemHeight + 'px'
                },
                rootWhenOpenRight: {
                    left: 'auto',
                    right: '0'
                }
            };
            styles.menuItemLink = this.mergeAndPrefix(styles.menuItem, {
                display: 'block',
                textDecoration: 'none',
                color: this.getThemePalette().textColor
            });
            styles.menuItemSubheader = this.mergeAndPrefix(styles.menuItem, {
                overflow: 'hidden'
            });

            return styles;
        },

        render: function render() {
            var selectedIndex = this.props.selectedIndex;
            var overlay;

            var styles = this.getStyles();
            if (!this.props.docked) {
                overlay = React.createElement(Overlay, { ref: 'overlay',
                    show: this.state.open,
                    transitionEnabled: !this.state.swiping,
                    onTouchTap: this._onOverlayTouchTap });
            }

            return React.createElement(
                'div',
                { className: this.props.className },
                overlay,
                React.createElement(
                    Paper,
                    {
                        ref: 'clickAwayableElement',
                        zDepth: 2,
                        rounded: false,
                        transitionEnabled: !this.state.swiping,
                        style: this.mergeAndPrefix(styles.root, this.props.openRight && styles.rootWhenOpenRight, this.props.style) },
                    this.props.header,
                    React.createElement(Menu, {
                        ref: 'menuItems',
                        style: this.mergeAndPrefix(styles.menu),
                        zDepth: 0,
                        menuItems: this.props.menuItems,
                        menuItemStyle: this.mergeAndPrefix(styles.menuItem),
                        menuItemStyleLink: this.mergeAndPrefix(styles.menuItemLink),
                        menuItemStyleSubheader: this.mergeAndPrefix(styles.menuItemSubheader),
                        selectedIndex: selectedIndex,
                        onItemTap: this._onMenuItemClick })
                )
            );
        },

        _updateMenuHeight: function _updateMenuHeight() {
            if (this.props.header) {
                var container = React.findDOMNode(this.refs.clickAwayableElement);
                var menu = React.findDOMNode(this.refs.menuItems);
                var menuHeight = container.clientHeight - menu.offsetTop;
                menu.style.height = menuHeight + 'px';
            }
        },

        _onMenuItemClick: function _onMenuItemClick(e, key, payload) {
            if (this.props.onChange && this.props.selectedIndex !== key) {
                this.props.onChange(e, key, payload);
            }
            if (!this.props.docked) this.close();
        },

        _onOverlayTouchTap: function _onOverlayTouchTap() {
            this.close();
        },

        _onWindowKeyUp: function _onWindowKeyUp(e) {
            if (e.keyCode == KeyCode.ESC && !this.props.docked && this.state.open) {
                this.close();
            }
        },

        _onWindowResize: function _onWindowResize(e) {
            this._updateMenuHeight();
        },

        _getMaxTranslateX: function _getMaxTranslateX() {
            return this.getTheme().width + 10;
        },

        _getTranslateMultiplier: function _getTranslateMultiplier() {
            return this.props.openRight ? 1 : -1;
        },

        _enableSwipeHandling: function _enableSwipeHandling() {
            if (this.state.open && !this.props.docked) {
                document.body.addEventListener('touchstart', this._onBodyTouchStart);
            } else {
                this._disableSwipeHandling();
            }
        },

        _disableSwipeHandling: function _disableSwipeHandling() {
            document.body.removeEventListener('touchstart', this._onBodyTouchStart);
        },

        _onBodyTouchStart: function _onBodyTouchStart(e) {
            var touchStartX = e.touches[0].pageX;
            var touchStartY = e.touches[0].pageY;
            this.setState({
                maybeSwiping: true,
                touchStartX: touchStartX,
                touchStartY: touchStartY
            });

            document.body.addEventListener('touchmove', this._onBodyTouchMove);
            document.body.addEventListener('touchend', this._onBodyTouchEnd);
            document.body.addEventListener('touchcancel', this._onBodyTouchEnd);
        },

        _onBodyTouchMove: function _onBodyTouchMove(e) {
            var currentX = e.touches[0].pageX;
            var currentY = e.touches[0].pageY;

            if (this.state.swiping) {
                e.preventDefault();
                var translateX = Math.min(Math.max(this._getTranslateMultiplier() * (currentX - this.state.swipeStartX), 0), this._getMaxTranslateX());

                var leftNav = React.findDOMNode(this.refs.clickAwayableElement);
                leftNav.style[AutoPrefix.single('transform')] = 'translate3d(' + this._getTranslateMultiplier() * translateX + 'px, 0, 0)';
                this.refs.overlay.setOpacity(1 - translateX / this._getMaxTranslateX());
            } else if (this.state.maybeSwiping) {
                var dXAbs = Math.abs(currentX - this.state.touchStartX);
                var dYAbs = Math.abs(currentY - this.state.touchStartY);
                // If the user has moved his thumb ten pixels in either direction,
                // we can safely make an assumption about whether he was intending
                // to swipe or scroll.
                var threshold = 10;

                if (dXAbs > threshold && dYAbs <= threshold) {
                    this.setState({
                        swiping: true,
                        swipeStartX: currentX
                    });
                } else if (dXAbs <= threshold && dYAbs > threshold) {
                    this._onBodyTouchEnd();
                }
            }
        },

        _onBodyTouchEnd: function _onBodyTouchEnd() {
            var shouldClose = false;

            if (this.state.swiping) shouldClose = true;

            this.setState({
                maybeSwiping: false,
                swiping: false
            });

            // We have to call close() after setting swiping to false,
            // because only then CSS transition is enabled.
            if (shouldClose) this.close();

            document.body.removeEventListener('touchmove', this._onBodyTouchMove);
            document.body.removeEventListener('touchend', this._onBodyTouchEnd);
            document.body.removeEventListener('touchcancel', this._onBodyTouchEnd);
        }

    });

    module.exports = LeftNav;
},{"./menu/menu":32,"./mixins/style-propable":36,"./mixins/window-listenable":38,"./overlay":39,"./paper":40,"./styles/auto-prefix":49,"./styles/transitions":55,"./utils/key-code":97,"react":"react"}],29:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');

    var LinearProgress = React.createClass({
        displayName: 'LinearProgress',

        mixins: [StylePropable],

        propTypes: {
            mode: React.PropTypes.oneOf(['determinate', 'indeterminate']),
            value: React.PropTypes.number,
            min: React.PropTypes.number,
            max: React.PropTypes.number
        },

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        _getRelativeValue: function _getRelativeValue() {
            var value = this.props.value;
            var min = this.props.min;
            var max = this.props.max;

            var clampedValue = Math.min(Math.max(min, value), max);
            var rangeValue = max - min;
            var relValue = Math.round(clampedValue / rangeValue * 10000) / 10000;
            return relValue * 100;
        },

        componentDidMount: function componentDidMount() {

            var bar1 = React.findDOMNode(this.refs.bar1);
            var bar2 = React.findDOMNode(this.refs.bar2);

            this._barUpdate(0, bar1, [[-35, 100], [100, -90]]);

            setTimeout((function () {

                this._barUpdate(0, bar2, [[-200, 100], [107, -8]]);
            }).bind(this), 850);
        },

        _barUpdate: function _barUpdate(step, barElement, stepValues) {
            step = step || 0;
            step %= 4;
            setTimeout(this._barUpdate.bind(this, step + 1, barElement, stepValues), 420);
            if (!this.isMounted()) return;
            if (this.props.mode != 'indeterminate') return;

            if (step === 0) {
                barElement.style.left = stepValues[0][0] + '%';
                barElement.style.right = stepValues[0][1] + '%';
            } else if (step == 1) {

                barElement.style.transitionDuration = '840ms';
            } else if (step == 2) {

                barElement.style.left = stepValues[1][0] + '%';
                barElement.style.right = stepValues[1][1] + '%';
            } else if (step == 3) {
                barElement.style.transitionDuration = '0ms';
            }
        },

        getDefaultProps: function getDefaultProps() {
            return {
                mode: 'indeterminate',
                value: 0,
                min: 0,
                max: 100
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.palette;
        },

        getStyles: function getStyles() {

            var styles = {
                root: {
                    position: 'relative',
                    height: '4px',
                    display: 'block',
                    width: '100%',
                    backgroundColor: this.getTheme().primary3Color,
                    borderRadius: '2px',
                    margin: 0,
                    overflow: 'hidden'
                },
                bar: {
                    height: '100%'
                },
                barFragment1: {},
                barFragment2: {}
            };

            if (this.props.mode == 'indeterminate') {
                styles.barFragment1 = {
                    position: 'absolute',
                    backgroundColor: this.getTheme().primary1Color,
                    top: 0,
                    left: 0,
                    bottom: 0,
                    transition: Transitions.create('all', '840ms', null, 'cubic-bezier(0.650, 0.815, 0.735, 0.395)')
                };

                styles.barFragment2 = {
                    position: 'absolute',
                    backgroundColor: this.getTheme().primary1Color,
                    top: 0,
                    left: 0,
                    bottom: 0,
                    transition: Transitions.create('all', '840ms', null, 'cubic-bezier(0.165, 0.840, 0.440, 1.000)')
                };
            } else {
                styles.bar.backgroundColor = this.getTheme().primary1Color;
                styles.bar.transition = Transitions.create('width', '.3s', null, 'linear');
                styles.bar.width = this._getRelativeValue() + '%';
            }

            return styles;
        },

        render: function render() {
            var _props = this.props;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['style']);

            var styles = this.getStyles();

            return React.createElement(
                'div',
                _extends({}, other, { style: this.mergeAndPrefix(styles.root, style) }),
                React.createElement(
                    'div',
                    { style: this.mergeAndPrefix(styles.bar) },
                    React.createElement('div', { ref: 'bar1', style: this.mergeAndPrefix(styles.barFragment1) }),
                    React.createElement('div', { ref: 'bar2', style: this.mergeAndPrefix(styles.barFragment2) })
                )
            );
        }
    });

    module.exports = LinearProgress;
},{"./mixins/style-propable":36,"./styles/transitions":55,"react":"react"}],30:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var LinkMenuItem = React.createClass({
        displayName: 'LinkMenuItem',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            index: React.PropTypes.number.isRequired,
            payload: React.PropTypes.string.isRequired,
            text: React.PropTypes.string.isRequired,
            target: React.PropTypes.string,
            disabled: React.PropTypes.bool,
            className: React.PropTypes.string },

        getDefaultProps: function getDefaultProps() {
            return {
                disabled: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                hovered: false
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.menuItem;
        },

        getStyles: function getStyles() {
            var style = {
                root: {
                    userSelect: 'none',
                    cursor: 'pointer',
                    display: 'block',
                    lineHeight: this.getTheme().height + 'px',
                    paddingLeft: this.getTheme().padding,
                    paddingRight: this.getTheme().padding
                },
                rootWhenHovered: {
                    backgroundColor: this.getTheme().hoverColor
                },
                rootWhenSelected: {
                    color: this.getTheme().selectedTextColor
                },
                rootWhenDisabled: {
                    cursor: 'default',
                    color: this.context.muiTheme.palette.disabledColor
                }
            };
            return style;
        },

        render: function render() {
            var onClickHandler = this.props.disabled ? this._stopLink : undefined;
            // Prevent context menu 'Open In New Tab/Window'
            var linkAttribute = this.props.disabled ? 'data-href' : 'href';
            var link = {};
            link[linkAttribute] = this.props.payload;

            var styles = this.getStyles();

            var linkStyles = this.mergeAndPrefix(styles.root, this.props.selected && styles.rootWhenSelected, this.state.hovered && !this.props.disabled && styles.rootWhenHovered, this.props.style, this.props.disabled && styles.rootWhenDisabled);

            return React.createElement(
                'a',
                _extends({
                    key: this.props.index,
                    target: this.props.target,
                    style: linkStyles }, link, {
                    className: this.props.className,
                    onClick: onClickHandler,
                    onMouseOver: this._handleMouseOver,
                    onMouseOut: this._handleMouseOut }),
                this.props.text
            );
        },

        _stopLink: function _stopLink(event) {
            event.preventDefault();
        },

        _handleMouseOver: function _handleMouseOver(e) {
            this.setState({ hovered: true });
            if (!this.props.disabled && this.props.onMouseOver) this.props.onMouseOver(e);
        },

        _handleMouseOut: function _handleMouseOut(e) {
            this.setState({ hovered: false });
            if (!this.props.disabled && this.props.onMouseOut) this.props.onMouseOut(e);
        }
    });

    module.exports = LinkMenuItem;
},{"../mixins/style-propable":36,"react":"react"}],31:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var FontIcon = require('../font-icon');
    var Toggle = require('../toggle');

    var Types = {
        LINK: 'LINK',
        SUBHEADER: 'SUBHEADER',
        NESTED: 'NESTED'
    };

    var MenuItem = React.createClass({
        displayName: 'MenuItem',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            index: React.PropTypes.number.isRequired,
            className: React.PropTypes.string,
            iconClassName: React.PropTypes.string,
            iconRightClassName: React.PropTypes.string,
            iconStyle: React.PropTypes.object,
            iconRightStyle: React.PropTypes.object,
            attribute: React.PropTypes.string,
            number: React.PropTypes.string,
            data: React.PropTypes.string,
            toggle: React.PropTypes.bool,
            disabled: React.PropTypes.bool,
            onTouchTap: React.PropTypes.func,
            onToggle: React.PropTypes.func,
            selected: React.PropTypes.bool
        },

        statics: {
            Types: Types
        },

        getDefaultProps: function getDefaultProps() {
            return {
                toggle: false,
                disabled: false
            };
        },

        getInitialState: function getInitialState() {
            return {
                hovered: false
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.menuItem;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    userSelect: 'none',
                    cursor: 'pointer',
                    lineHeight: this.getTheme().height + 'px',
                    paddingLeft: this.getTheme().padding,
                    paddingRight: this.getTheme().padding,
                    color: this.context.muiTheme.palette.textColor
                },
                number: {
                    float: 'right',
                    width: 24,
                    textAlign: 'center'
                },
                attribute: {
                    float: 'right'
                },
                iconRight: {
                    lineHeight: this.getTheme().height + 'px',
                    float: 'right'
                },
                icon: {
                    float: 'left',
                    lineHeight: this.getTheme().height + 'px',
                    marginRight: this.getSpacing().desktopGutter
                },
                data: {
                    display: 'block',
                    paddingLeft: this.getSpacing().desktopGutter * 2,
                    lineHeight: this.getTheme().dataHeight + 'px',
                    height: this.getTheme().dataHeight + 'px',
                    verticalAlign: 'top',
                    top: -12,
                    position: 'relative',
                    fontWeight: 300,
                    color: this.context.muiTheme.palette.textColor
                },
                toggle: {
                    marginTop: (this.getTheme().height - this.context.muiTheme.component.radioButton.size) / 2,
                    float: 'right',
                    width: 42
                },
                rootWhenHovered: {
                    backgroundColor: this.getTheme().hoverColor
                },
                rootWhenSelected: {
                    color: this.getTheme().selectedTextColor
                },
                rootWhenDisabled: {
                    cursor: 'default',
                    color: this.context.muiTheme.palette.disabledColor
                }
            };
            return styles;
        },

        render: function render() {
            var icon;
            var data;
            var iconRight;
            var attribute;
            var number;
            var toggleElement;

            var styles = this.getStyles();

            if (this.props.iconClassName) icon = React.createElement(FontIcon, { style: this.mergeAndPrefix(styles.icon, this.props.iconStyle), className: this.props.iconClassName });
            if (this.props.iconRightClassName) iconRight = React.createElement(FontIcon, { style: this.mergeAndPrefix(styles.iconRight, this.props.iconRightStyle), className: this.props.iconRightClassName });
            if (this.props.data) data = React.createElement(
                'span',
                { style: this.mergeAndPrefix(styles.data) },
                this.props.data
            );
            if (this.props.number !== undefined) number = React.createElement(
                'span',
                { style: this.mergeAndPrefix(styles.number) },
                this.props.number
            );
            if (this.props.attribute !== undefined) attribute = React.createElement(
                'span',
                { style: this.mergeAndPrefix(styles.style) },
                this.props.attribute
            );

            if (this.props.toggle) {
                var _props = this.props;
                var toggle = _props.toggle;
                var onTouchTap = _props.onTouchTap;
                var onToggle = _props.onToggle;
                var onMouseOver = _props.onMouseOver;
                var onMouseOut = _props.onMouseOut;
                var children = _props.children;
                var label = _props.label;
                var style = _props.style;

                var other = _objectWithoutProperties(_props, ['toggle', 'onTouchTap', 'onToggle', 'onMouseOver', 'onMouseOut', 'children', 'label', 'style']);

                toggleElement = React.createElement(Toggle, _extends({}, other, { onToggle: this._handleToggle, style: styles.toggle }));
            }

            return React.createElement(
                'div',
                {
                    key: this.props.index,
                    className: this.props.className,
                    onTouchTap: this._handleTouchTap,
                    onMouseOver: this._handleMouseOver,
                    onMouseOut: this._handleMouseOut,
                    style: this.mergeAndPrefix(styles.root, this.props.selected && styles.rootWhenSelected, this.state.hovered && !this.props.disabled && styles.rootWhenHovered, this.props.style, this.props.disabled && styles.rootWhenDisabled) },
                icon,
                this.props.children,
                data,
                attribute,
                number,
                toggleElement,
                iconRight
            );
        },

        _handleTouchTap: function _handleTouchTap(e) {
            if (!this.props.disabled && this.props.onTouchTap) this.props.onTouchTap(e, this.props.index);
        },

        _handleToggle: function _handleToggle(e, toggled) {
            if (!this.props.disabled && this.props.onToggle) this.props.onToggle(e, this.props.index, toggled);
        },

        _handleMouseOver: function _handleMouseOver(e) {
            this.setState({ hovered: true });
            if (!this.props.disabled && this.props.onMouseOver) this.props.onMouseOver(e);
        },

        _handleMouseOut: function _handleMouseOut(e) {
            this.setState({ hovered: false });
            if (!this.props.disabled && this.props.onMouseOut) this.props.onMouseOut(e);
        }

    });

    module.exports = MenuItem;
},{"../font-icon":25,"../mixins/style-propable":36,"../toggle":83,"react":"react"}],32:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var CssEvent = require('../utils/css-event');
    var Dom = require('../utils/dom');
    var KeyLine = require('../utils/key-line');
    var StylePropable = require('../mixins/style-propable');
    var Transitions = require('../styles/transitions');
    var ClickAwayable = require('../mixins/click-awayable');
    var Paper = require('../paper');
    var MenuItem = require('./menu-item');
    var LinkMenuItem = require('./link-menu-item');
    var SubheaderMenuItem = require('./subheader-menu-item');

    /***********************
     * Nested Menu Component
     ***********************/
    var NestedMenuItem = React.createClass({
        displayName: 'NestedMenuItem',

        mixins: [ClickAwayable, StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            index: React.PropTypes.number.isRequired,
            text: React.PropTypes.string,
            menuItems: React.PropTypes.array.isRequired,
            zDepth: React.PropTypes.number,
            disabled: React.PropTypes.bool,
            onItemTap: React.PropTypes.func,
            menuItemStyle: React.PropTypes.object },

        getDefaultProps: function getDefaultProps() {
            return {
                disabled: false
            };
        },

        getInitialState: function getInitialState() {
            return { open: false };
        },

        componentClickAway: function componentClickAway() {
            this._closeNestedMenu();
        },

        componentDidMount: function componentDidMount() {
            this._positionNestedMenu();
        },

        componentDidUpdate: function componentDidUpdate() {
            this._positionNestedMenu();
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        render: function render() {
            var styles = this.mergeAndPrefix({
                position: 'relative'
            }, this.props.style);

            var iconCustomArrowDropRight = {
                marginRight: this.getSpacing().desktopGutterMini * -1,
                color: this.context.muiTheme.component.dropDownMenu.accentColor
            };

            var _props = this.props;
            var index = _props.index;
            var menuItemStyle = _props.menuItemStyle;

            var other = _objectWithoutProperties(_props, ['index', 'menuItemStyle']);

            return React.createElement(
                'div',
                { ref: 'root', style: styles, onMouseEnter: this._openNestedMenu, onMouseLeave: this._closeNestedMenu },
                React.createElement(
                    MenuItem,
                    {
                        index: index,
                        style: menuItemStyle,
                        disabled: this.props.disabled,
                        iconRightStyle: iconCustomArrowDropRight,
                        iconRightClassName: 'muidocs-icon-custom-arrow-drop-right',
                        onTouchTap: this._onParentItemTap },
                    this.props.text
                ),
                React.createElement(Menu, _extends({}, other, {
                    ref: 'nestedMenu',
                    menuItems: this.props.menuItems,
                    menuItemStyle: menuItemStyle,
                    onItemTap: this._onMenuItemTap,
                    hideable: true,
                    visible: this.state.open,
                    zDepth: this.props.zDepth + 1 }))
            );
        },

        _positionNestedMenu: function _positionNestedMenu() {
            var el = React.findDOMNode(this);
            var nestedMenu = React.findDOMNode(this.refs.nestedMenu);

            nestedMenu.style.left = el.offsetWidth + 'px';
        },

        _openNestedMenu: function _openNestedMenu() {
            if (!this.props.disabled) this.setState({ open: true });
        },

        _closeNestedMenu: function _closeNestedMenu() {
            this.setState({ open: false });
        },

        _toggleNestedMenu: function _toggleNestedMenu() {
            if (!this.props.disabled) this.setState({ open: !this.state.open });
        },

        _onParentItemTap: function _onParentItemTap() {
            this._toggleNestedMenu();
        },

        _onMenuItemTap: function _onMenuItemTap(e, index, menuItem) {
            if (this.props.onItemTap) this.props.onItemTap(e, index, menuItem);
            this._closeNestedMenu();
        }

    });

    /****************
     * Menu Component
     ****************/
    var Menu = React.createClass({
        displayName: 'Menu',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            autoWidth: React.PropTypes.bool,
            onItemTap: React.PropTypes.func,
            onToggle: React.PropTypes.func,
            menuItems: React.PropTypes.array.isRequired,
            selectedIndex: React.PropTypes.number,
            hideable: React.PropTypes.bool,
            visible: React.PropTypes.bool,
            zDepth: React.PropTypes.number,
            menuItemStyle: React.PropTypes.object,
            menuItemStyleSubheader: React.PropTypes.object,
            menuItemStyleLink: React.PropTypes.object,
            menuItemClassName: React.PropTypes.string,
            menuItemClassNameSubheader: React.PropTypes.string,
            menuItemClassNameLink: React.PropTypes.string },

        getInitialState: function getInitialState() {
            return { nestedMenuShown: false };
        },

        getDefaultProps: function getDefaultProps() {
            return {
                autoWidth: true,
                hideable: false,
                visible: true,
                zDepth: 1 };
        },

        componentDidMount: function componentDidMount() {
            var el = React.findDOMNode(this);

            //Set the menu width
            this._setKeyWidth(el);

            //Save the initial menu item height for later
            this._initialMenuItemHeight = el.offsetHeight / Math.max(1, this.props.menuItems.length);

            //Show or Hide the menu according to visibility
            this._renderVisibility();
        },

        componentDidUpdate: function componentDidUpdate(prevProps) {
            if (this.props.visible !== prevProps.visible) this._renderVisibility();
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.menu;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    backgroundColor: this.getTheme().containerBackgroundColor,
                    paddingTop: this.getSpacing().desktopGutterMini,
                    paddingBottom: this.getSpacing().desktopGutterMini,
                    transition: Transitions.easeOut(null, 'height')
                },
                subheader: {
                    paddingLeft: this.context.muiTheme.component.menuSubheader.padding,
                    paddingRight: this.context.muiTheme.component.menuSubheader.padding
                },
                hideable: {
                    opacity: this.props.visible ? 1 : 0,
                    overflow: 'hidden',
                    position: 'absolute',
                    top: 0,
                    zIndex: 1
                }
            };
            return styles;
        },

        render: function render() {
            var styles = this.getStyles();
            return React.createElement(
                Paper,
                {
                    ref: 'paperContainer',
                    zDepth: this.props.zDepth,
                    style: this.mergeAndPrefix(styles.root, this.props.hideable && styles.hideable, this.props.style) },
                this._getChildren()
            );
        },

        _getChildren: function _getChildren() {
            var children = [],
                menuItem,
                itemComponent,
                isSelected,
                isDisabled;

            var styles = this.getStyles();

            //This array is used to keep track of all nested menu refs
            this._nestedChildren = [];

            for (var i = 0; i < this.props.menuItems.length; i++) {
                menuItem = this.props.menuItems[i];
                isSelected = i === this.props.selectedIndex;
                isDisabled = menuItem.disabled === undefined ? false : menuItem.disabled;

                var icon = menuItem.icon;
                var data = menuItem.data;
                var attribute = menuItem.attribute;
                var number = menuItem.number;
                var toggle = menuItem.toggle;
                var onTouchTap = menuItem.onTouchTap;

                var other = _objectWithoutProperties(menuItem, ['icon', 'data', 'attribute', 'number', 'toggle', 'onTouchTap']);

                switch (menuItem.type) {

                    case MenuItem.Types.LINK:
                        itemComponent = React.createElement(LinkMenuItem, {
                            key: i,
                            index: i,
                            text: menuItem.text,
                            disabled: isDisabled,
                            className: this.props.menuItemClassNameLink,
                            style: this.props.menuItemStyleLink,
                            payload: menuItem.payload,
                            target: menuItem.target });
                        break;

                    case MenuItem.Types.SUBHEADER:
                        itemComponent = React.createElement(SubheaderMenuItem, {
                            key: i,
                            index: i,
                            className: this.props.menuItemClassNameSubheader,
                            style: this.mergeAndPrefix(styles.subheader),
                            firstChild: i === 0,
                            text: menuItem.text });
                        break;

                    case MenuItem.Types.NESTED:
                        var _props2 = this.props,
                            ref = _props2.ref,
                            key = _props2.key,
                            index = _props2.index,
                            zDepth = _props2.zDepth,
                            other = _objectWithoutProperties(_props2, ['ref', 'key', 'index', 'zDepth']);

                        itemComponent = React.createElement(NestedMenuItem, _extends({}, other, {
                            ref: i,
                            key: i,
                            index: i,
                            text: menuItem.text,
                            disabled: isDisabled,
                            menuItems: menuItem.items,
                            menuItemStyle: this.props.menuItemStyle,
                            zDepth: this.props.zDepth,
                            onItemTap: this._onNestedItemTap }));
                        this._nestedChildren.push(i);
                        break;

                    default:
                        itemComponent = React.createElement(
                            MenuItem,
                            _extends({}, other, {
                                selected: isSelected,
                                key: i,
                                index: i,
                                icon: menuItem.icon,
                                data: menuItem.data,
                                className: this.props.menuItemClassName,
                                style: this.props.menuItemStyle,
                                attribute: menuItem.attribute,
                                number: menuItem.number,
                                toggle: menuItem.toggle,
                                onToggle: this.props.onToggle,
                                disabled: isDisabled,
                                onTouchTap: this._onItemTap }),
                            menuItem.text
                        );
                }
                children.push(itemComponent);
            }

            return children;
        },

        _setKeyWidth: function _setKeyWidth(el) {
            var menuWidth = this.props.autoWidth ? KeyLine.getIncrementalDim(el.offsetWidth) + 'px' : '100%';

            //Update the menu width
            Dom.withoutTransition(el, function () {
                el.style.width = menuWidth;
            });
        },

        _getCurrentHeight: function _getCurrentHeight() {
            var totalItens = Math.max(1, this.props.menuItems.length);
            var newHeight = this._initialMenuItemHeight * totalItens;

            return newHeight + KeyLine.Desktop.GUTTER_LESS;
        },

        _renderVisibility: function _renderVisibility() {
            var el;

            if (this.props.hideable) {
                el = React.findDOMNode(this);
                var container = React.findDOMNode(this.refs.paperContainer);

                if (this.props.visible) {
                    //Open the menu
                    el.style.transition = Transitions.easeOut();
                    el.style.height = this._getCurrentHeight() + 'px';

                    //Set the overflow to visible after the animation is done so
                    //that other nested menus can be shown
                    CssEvent.onTransitionEnd(el, (function () {
                        //Make sure the menu is open before setting the overflow.
                        //This is to accout for fast clicks
                        if (this.props.visible) container.style.overflow = 'visible';
                    }).bind(this));
                } else {

                    //Close the menu
                    el.style.height = '0px';

                    //Set the overflow to hidden so that animation works properly
                    container.style.overflow = 'hidden';
                }
            }
        },

        _onNestedItemTap: function _onNestedItemTap(e, index, menuItem) {
            if (this.props.onItemTap) this.props.onItemTap(e, index, menuItem);
        },

        _onItemTap: function _onItemTap(e, index) {
            if (this.props.onItemTap) this.props.onItemTap(e, index, this.props.menuItems[index]);
        },

        _onItemToggle: function _onItemToggle(e, index, toggled) {
            if (this.props.onItemToggle) this.props.onItemToggle(e, index, this.props.menuItems[index], toggled);
        }

    });

    module.exports = Menu;
},{"../mixins/click-awayable":35,"../mixins/style-propable":36,"../paper":40,"../styles/transitions":55,"../utils/css-event":92,"../utils/dom":94,"../utils/key-line":98,"./link-menu-item":30,"./menu-item":31,"./subheader-menu-item":33,"react":"react"}],33:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var Typography = require('../styles/typography');

    var SubheaderMenuItem = React.createClass({
        displayName: 'SubheaderMenuItem',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            index: React.PropTypes.number.isRequired,
            text: React.PropTypes.string.isRequired,
            firstChild: React.PropTypes.bool,
            className: React.PropTypes.string },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.menuSubheader;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        getStyles: function getStyles() {
            var gutterMini = this.getSpacing().desktopGutterMini;
            var subheaderHeight = this.getSpacing().desktopSubheaderHeight;
            var styles = {
                root: {
                    boxSizing: 'border-box',
                    fontSize: '13px',
                    letterSpacing: 0,
                    fontWeight: Typography.fontWeightMedium,
                    margin: 0,
                    height: subheaderHeight + gutterMini,
                    lineHeight: subheaderHeight + 'px',
                    color: this.getTheme().textColor,
                    borderTop: 'solid 1px ' + this.getTheme().borderColor,
                    paddingTop: gutterMini,
                    marginTop: gutterMini
                },
                rootWhenFirstChild: {
                    height: subheaderHeight,
                    borderTop: 'none',
                    paddingTop: 0,
                    marginTop: 0
                }
            };
            return styles;
        },

        render: function render() {
            return React.createElement(
                'div',
                {
                    key: this.props.index,
                    className: this.props.className,
                    style: this.mergeAndPrefix(this.getStyles().root, this.props.firstChild && this.getStyles().rootWhenFirstChild, this.props.style) },
                this.props.text
            );
        }

    });

    module.exports = SubheaderMenuItem;
},{"../mixins/style-propable":36,"../styles/typography":56,"react":"react"}],34:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var classNames = require('classnames');

    module.exports = {

        propTypes: {
            className: React.PropTypes.string
        },

        getDefaultProps: function getDefaultProps() {
            return {
                className: ''
            };
        },

        getClasses: function getClasses(initialClasses, additionalClassObj) {
            var classString = '';

            //Initialize the classString with the classNames that were passed in
            if (this.props.className.length) classString += ' ' + this.props.className;

            //Add in initial classes
            if (typeof initialClasses === 'object') {
                classString += ' ' + classNames(initialClasses);
            } else {
                classString += ' ' + initialClasses;
            }

            //Add in additional classes
            if (additionalClassObj) classString += ' ' + classNames(additionalClassObj);

            //Convert the class string into an object and run it through the class set
            return classNames(this.getClassSet(classString));
        },

        getClassSet: function getClassSet(classString) {
            var classObj = {};

            if (classString) {
                classString.split(' ').forEach(function (className) {
                    if (className) classObj[className] = true;
                });
            }

            return classObj;
        }

    };
},{"classnames":101,"react":"react"}],35:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var Events = require('../utils/events');
    var Dom = require('../utils/dom');

    module.exports = {

        //When the component mounts, listen to click events and check if we need to
        //Call the componentClickAway function.
        componentDidMount: function componentDidMount() {
            if (!this.manuallyBindClickAway) this._bindClickAway();
        },

        componentWillUnmount: function componentWillUnmount() {
            this._unbindClickAway();
        },

        _checkClickAway: function _checkClickAway(e) {
            var el = React.findDOMNode(this);

            // Check if the target is inside the current component
            if (e.target != el && !Dom.isDescendant(el, e.target) && document.documentElement.contains(e.target)) {
                if (this.componentClickAway) this.componentClickAway();
            }
        },

        _bindClickAway: function _bindClickAway() {
            // On touch-enabled devices, both events fire, and the handler is called twice,
            // but it's fine since all operations for which the mixin is used
            // are idempotent.
            Events.on(document, 'mouseup', this._checkClickAway);
            Events.on(document, 'touchend', this._checkClickAway);
        },

        _unbindClickAway: function _unbindClickAway() {
            Events.off(document, 'mouseup', this._checkClickAway);
            Events.off(document, 'touchend', this._checkClickAway);
        }

    };
},{"../utils/dom":94,"../utils/events":95,"react":"react"}],36:[function(require,module,exports){
    'use strict';

    var React = require('react/addons');
    var AutoPrefix = require('../styles/auto-prefix');
    var Extend = require('../utils/extend');

    /**
     *	@params:
     *	styles = Current styles.
     *  props = New style properties that will override the current style.
     */
    module.exports = {

        propTypes: {
            style: React.PropTypes.object
        },

        mergeStyles: function mergeStyles() {
            var args = Array.prototype.slice.call(arguments, 0);
            var base = args[0];
            for (var i = 1; i < args.length; i++) {
                if (args[i]) base = Extend(base, args[i]);
            }
            return base;
        },

        /**
         * loops through all properties defined in the first argument, so overrides
         * of undefined properties will not take place.
         */
        mergeAndPrefix: function mergeAndPrefix() {
            var mergedStyles = this.mergeStyles.apply(this, arguments);
            return AutoPrefix.all(mergedStyles);
        } };
},{"../styles/auto-prefix":49,"../utils/extend":96,"react/addons":"react/addons"}],37:[function(require,module,exports){
    'use strict';

    var Events = require('../utils/events');

    var Sizes = {
        SMALL: 1,
        MEDIUM: 2,
        LARGE: 3
    };

    module.exports = {

        statics: {
            Sizes: Sizes
        },

        getInitialState: function getInitialState() {
            return {
                deviceSize: Sizes.SMALL
            };
        },

        componentDidMount: function componentDidMount() {
            this._updateDeviceSize();
            if (!this.manuallyBindResize) this._bindResize();
        },

        componentWillUnmount: function componentWillUnmount() {
            this._unbindResize();
        },

        isDeviceSize: function isDeviceSize(desiredSize) {
            return this.state.deviceSize >= desiredSize;
        },

        _updateDeviceSize: function _updateDeviceSize() {
            var width = window.innerWidth;
            if (width >= 992) this.setState({ deviceSize: Sizes.LARGE });else if (width >= 768) this.setState({ deviceSize: Sizes.MEDIUM });else this.setState({ deviceSize: Sizes.SMALL }); // width >= 375
        },

        _bindResize: function _bindResize() {
            Events.on(window, 'resize', this._updateDeviceSize);
        },

        _unbindResize: function _unbindResize() {
            Events.off(window, 'resize', this._updateDeviceSize);
        }
    };
},{"../utils/events":95}],38:[function(require,module,exports){
    'use strict';

    var Events = require('../utils/events');

    module.exports = {

        componentDidMount: function componentDidMount() {
            var listeners = this.windowListeners;

            for (var eventName in listeners) {
                var callbackName = listeners[eventName];
                Events.on(window, eventName, this[callbackName]);
            }
        },

        componentWillUnmount: function componentWillUnmount() {
            var listeners = this.windowListeners;

            for (var eventName in listeners) {
                var callbackName = listeners[eventName];
                Events.off(window, eventName, this[callbackName]);
            }
        }

    };
},{"../utils/events":95}],39:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var Colors = require('./styles/colors');

    var Overlay = React.createClass({
        displayName: 'Overlay',

        mixins: [StylePropable],

        propTypes: {
            show: React.PropTypes.bool,
            autoLockScrolling: React.PropTypes.bool,
            transitionEnabled: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                autoLockScrolling: true,
                transitionEnabled: true
            };
        },

        componentDidUpdate: function componentDidUpdate() {
            if (this.props.autoLockScrolling) this.props.show ? this._preventScrolling() : this._allowScrolling();
        },

        setOpacity: function setOpacity(opacity) {
            var overlay = React.findDOMNode(this);
            overlay.style.opacity = opacity;
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    position: 'fixed',
                    height: '100%',
                    width: '100%',
                    zIndex: 9,
                    top: 0,
                    left: '-100%',
                    opacity: 0,
                    backgroundColor: Colors.lightBlack,
                    WebkitTapHighlightColor: 'rgba(0, 0, 0, 0)',

                    // Two ways to promote overlay to its own render layer
                    willChange: 'opacity',
                    transform: 'translateZ(0)',

                    transition: this.props.transitionEnabled && Transitions.easeOut('0ms', 'left', '400ms') + ',' + Transitions.easeOut('400ms', 'opacity')
                },
                rootWhenShown: {
                    left: '0',
                    opacity: 1,
                    transition: this.props.transitionEnabled && Transitions.easeOut('0ms', 'left') + ',' + Transitions.easeOut('400ms', 'opacity')
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var show = _props.show;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['show', 'style']);

            var styles = this.mergeAndPrefix(this.getStyles().root, this.props.style, this.props.show && this.getStyles().rootWhenShown);

            return React.createElement('div', _extends({}, other, { style: styles }));
        },

        preventScrolling: function preventScrolling() {
            if (!this.props.autoLockScrolling) this._preventScrolling();
        },

        allowScrolling: function allowScrolling() {
            if (!this.props.autoLockScrolling) this._allowScrolling();
        },

        _preventScrolling: function _preventScrolling() {
            var body = document.getElementsByTagName('body')[0];
            body.style.overflow = 'hidden';
        },

        _allowScrolling: function _allowScrolling() {
            var body = document.getElementsByTagName('body')[0];
            body.style.overflow = '';
        }

    });

    module.exports = Overlay;
},{"./mixins/style-propable":36,"./styles/colors":50,"./styles/transitions":55,"react":"react"}],40:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var Paper = React.createClass({
        displayName: 'Paper',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            circle: React.PropTypes.bool,
            rounded: React.PropTypes.bool,
            zDepth: React.PropTypes.oneOf([0, 1, 2, 3, 4, 5]),
            transitionEnabled: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                rounded: true,
                zDepth: 1,
                transitionEnabled: true
            };
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    backgroundColor: this.context.muiTheme.component.paper.backgroundColor,
                    transition: this.props.transitionEnabled && Transitions.easeOut(),
                    boxSizing: 'border-box',
                    fontFamily: this.context.muiTheme.contentFontFamily,
                    WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                    boxShadow: this._getZDepthShadows(this.props.zDepth),
                    borderRadius: this.props.circle ? '50%' : this.props.rounded ? '2px' : '0px'
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var style = _props.style;
            var circle = _props.circle;
            var rounded = _props.rounded;
            var zDepth = _props.zDepth;

            var other = _objectWithoutProperties(_props, ['style', 'circle', 'rounded', 'zDepth']);

            var styles = this.getStyles();

            return React.createElement(
                'div',
                _extends({}, other, { style: this.mergeAndPrefix(styles.root, this.props.style) }),
                this.props.children
            );
        },

        _getZDepthShadows: function _getZDepthShadows(zDepth) {
            var shadows = ['', '0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24)', '0 3px 10px rgba(0, 0, 0, 0.16), 0 3px 10px rgba(0, 0, 0, 0.23)', '0 10px 30px rgba(0, 0, 0, 0.19), 0 6px 10px rgba(0, 0, 0, 0.23)', '0 14px 45px rgba(0, 0, 0, 0.25), 0 10px 18px rgba(0, 0, 0, 0.22)', '0 19px 60px rgba(0, 0, 0, 0.30), 0 15px 20px rgba(0, 0, 0, 0.22)'];

            return shadows[zDepth];
        }

    });

    module.exports = Paper;
},{"./mixins/style-propable":36,"./styles/transitions":55,"react":"react"}],41:[function(require,module,exports){
    (function (process){
        'use strict';

        var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

        function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

        var React = require('react');
        var RadioButton = require('./radio-button');

        var RadioButtonGroup = React.createClass({
            displayName: 'RadioButtonGroup',

            propTypes: {
                name: React.PropTypes.string.isRequired,
                valueSelected: React.PropTypes.string,
                defaultSelected: React.PropTypes.string,
                labelPosition: React.PropTypes.oneOf(['left', 'right']),
                onChange: React.PropTypes.func
            },

            _hasCheckAttribute: function _hasCheckAttribute(radioButton) {
                return radioButton.props.hasOwnProperty('checked') && radioButton.props.checked;
            },

            getInitialState: function getInitialState() {
                return {
                    numberCheckedRadioButtons: 0,
                    selected: this.props.valueSelected || this.props.defaultSelected || ''
                };
            },

            componentWillMount: function componentWillMount() {
                var cnt = 0;

                this.props.children.forEach(function (option) {
                    if (this._hasCheckAttribute(option)) cnt++;
                }, this);

                this.setState({ numberCheckedRadioButtons: cnt });
            },

            componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
                if (nextProps.hasOwnProperty('valueSelected')) {
                    this.setState({ selected: nextProps.valueSelected });
                }
            },

            render: function render() {

                var options = this.props.children.map(function (option) {
                    var _option$props = option.props;
                    var name = _option$props.name;
                    var value = _option$props.value;
                    var label = _option$props.label;
                    var onCheck = _option$props.onCheck;

                    var other = _objectWithoutProperties(_option$props, ['name', 'value', 'label', 'onCheck']);

                    return React.createElement(RadioButton, _extends({}, other, {
                        ref: option.props.value,
                        name: this.props.name,
                        key: option.props.value,
                        value: option.props.value,
                        label: option.props.label,
                        labelPosition: this.props.labelPosition,
                        onCheck: this._onChange,
                        checked: option.props.value == this.state.selected }));
                }, this);

                return React.createElement(
                    'div',
                    { style: this.props.style },
                    options
                );
            },

            _updateRadioButtons: function _updateRadioButtons(newSelection) {
                if (this.state.numberCheckedRadioButtons === 0) {
                    this.setState({ selected: newSelection });
                } else if (process.env.NODE_ENV !== 'production') {
                    var message = 'Cannot select a different radio button while another radio button ' + 'has the \'checked\' property set to true.';
                    console.error(message);
                }
            },

            _onChange: function _onChange(e, newSelection) {
                this._updateRadioButtons(newSelection);

                // Successful update
                if (this.state.numberCheckedRadioButtons === 0) {
                    if (this.props.onChange) this.props.onChange(e, newSelection);
                }
            },

            getSelectedValue: function getSelectedValue() {
                return this.state.selected;
            },

            setSelectedValue: function setSelectedValue(newSelectionValue) {
                this._updateRadioButtons(newSelectionValue);
            },

            clearValue: function clearValue() {
                this.setSelectedValue('');
            }

        });

        module.exports = RadioButtonGroup;
    }).call(this,require('_process'))
},{"./radio-button":42,"_process":103,"react":"react"}],42:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var EnhancedSwitch = require('./enhanced-switch');
    var RadioButtonOff = require('./svg-icons/toggle-radio-button-off');
    var RadioButtonOn = require('./svg-icons/toggle-radio-button-on');

    var RadioButton = React.createClass({
        displayName: 'RadioButton',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            iconStyle: React.PropTypes.object,
            onCheck: React.PropTypes.func
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.radioButton;
        },

        getStyles: function getStyles() {
            var styles = {
                icon: {
                    height: this.getTheme().size,
                    width: this.getTheme().size
                },
                target: {
                    transition: Transitions.easeOut(),
                    position: 'absolute',
                    opacity: 1,
                    transform: 'scale(1)',
                    fill: this.getTheme().borderColor
                },
                fill: {
                    position: 'absolute',
                    opacity: 1,
                    transform: 'scale(0)',
                    transformOrigin: '50% 50%',
                    transition: Transitions.easeOut(),
                    fill: this.getTheme().checkedColor
                },
                targetWhenChecked: {
                    opacity: 0,
                    transform: 'scale(0)'
                },
                fillWhenChecked: {
                    opacity: 1,
                    transform: 'scale(1)'
                },
                targetWhenDisabled: {
                    fill: this.getTheme().disabledColor
                },
                fillWhenDisabled: {
                    fill: this.getTheme().disabledColor
                } };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var onCheck = _props.onCheck;

            var other = _objectWithoutProperties(_props, ['onCheck']);

            var styles = this.getStyles();
            var onStyles = this.mergeAndPrefix(styles.target, this.props.checked && styles.targetWhenChecked, this.props.iconStyle, this.props.disabled && styles.targetWhenDisabled);
            var offStyles = this.mergeAndPrefix(styles.fill, this.props.checked && styles.fillWhenChecked, this.props.iconStyle, this.props.disabled && styles.fillWhenDisabled);

            var radioButtonElement = React.createElement(
                'div',
                null,
                React.createElement(RadioButtonOff, { style: onStyles }),
                React.createElement(RadioButtonOn, { style: offStyles })
            );

            var rippleColor = this.props.checked ? this.getTheme().checkedColor : this.getTheme().borderColor;

            var enhancedSwitchProps = {
                ref: 'enhancedSwitch',
                inputType: 'radio',
                switched: this.props.checked || false,
                switchElement: radioButtonElement,
                rippleColor: rippleColor,
                iconStyle: styles.icon,
                onSwitch: this._handleCheck,
                onParentShouldUpdate: this._handleStateChange,
                labelPosition: this.props.labelPosition ? this.props.labelPosition : 'right'
            };

            return React.createElement(EnhancedSwitch, _extends({}, other, enhancedSwitchProps));
        },

        // Only called when selected, not when unselected.
        _handleCheck: function _handleCheck(e) {
            if (this.props.onCheck) this.props.onCheck(e, this.props.value);
        },

        _handleStateChange: function _handleStateChange() {},

        isChecked: function isChecked() {
            return this.refs.enhancedSwitch.isSwitched();
        },

        // Use RadioButtonGroup.setSelectedValue(newSelectionValue) to set a
        // RadioButton's checked value.
        setChecked: function setChecked(newCheckedValue) {
            this.refs.enhancedSwitch.setSwitched(newCheckedValue);
        },

        getValue: function getValue() {
            return this.refs.enhancedSwitch.getValue();
        }

    });

    module.exports = RadioButton;
},{"./enhanced-switch":21,"./mixins/style-propable":36,"./styles/transitions":55,"./svg-icons/toggle-radio-button-off":66,"./svg-icons/toggle-radio-button-on":67,"react":"react"}],43:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var ColorManipulator = require('./utils/color-manipulator');
    var Typography = require('./styles/typography');
    var EnhancedButton = require('./enhanced-button');
    var Paper = require('./paper');

    var RaisedButton = React.createClass({
        displayName: 'RaisedButton',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            label: function label(props, propName, componentName) {
                if (!props.children && !props.label) {
                    return new Error('Warning: Required prop `label` or `children` was not specified in `' + componentName + '`.');
                }
            },
            onMouseDown: React.PropTypes.func,
            onMouseUp: React.PropTypes.func,
            onMouseOut: React.PropTypes.func,
            onTouchEnd: React.PropTypes.func,
            onTouchStart: React.PropTypes.func,
            primary: React.PropTypes.bool,
            secondary: React.PropTypes.bool,
            labelStyle: React.PropTypes.object },

        getInitialState: function getInitialState() {
            var zDepth = this.props.disabled ? 0 : 1;
            return {
                zDepth: zDepth,
                initialZDepth: zDepth,
                hovered: false
            };
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            var zDepth = nextProps.disabled ? 0 : 1;
            this.setState({
                zDepth: zDepth,
                initialZDepth: zDepth });
        },

        _getBackgroundColor: function _getBackgroundColor() {
            return this.props.disabled ? this.getTheme().disabledColor : this.props.primary ? this.getTheme().primaryColor : this.props.secondary ? this.getTheme().secondaryColor : this.getTheme().color;
        },

        _getLabelColor: function _getLabelColor() {
            return this.props.disabled ? this.getTheme().disabledTextColor : this.props.primary ? this.getTheme().primaryTextColor : this.props.secondary ? this.getTheme().secondaryTextColor : this.getTheme().textColor;
        },

        getThemeButton: function getThemeButton() {
            return this.context.muiTheme.component.button;
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.raisedButton;
        },

        getStyles: function getStyles() {
            var amount = this.props.primary || this.props.secondary ? 0.4 : 0.08;
            var styles = {
                root: {
                    display: 'inline-block',
                    minWidth: this.getThemeButton().minWidth,
                    height: this.getThemeButton().height,
                    transition: Transitions.easeOut()
                },
                container: {
                    position: 'relative',
                    height: '100%',
                    width: '100%',
                    padding: 0,
                    overflow: 'hidden',
                    borderRadius: 2,
                    transition: Transitions.easeOut(),
                    backgroundColor: this._getBackgroundColor(),

                    //This is need so that ripples do not bleed
                    //past border radius.
                    //See: http://stackoverflow.com/questions/17298739/css-overflow-hidden-not-working-in-chrome-when-parent-has-border-radius-and-chil
                    transform: 'translate3d(0, 0, 0)'
                },
                label: {
                    position: 'relative',
                    opacity: 1,
                    fontSize: '14px',
                    letterSpacing: 0,
                    textTransform: 'uppercase',
                    fontWeight: Typography.fontWeightMedium,
                    margin: 0,
                    padding: '0px ' + this.context.muiTheme.spacing.desktopGutterLess + 'px',
                    userSelect: 'none',
                    lineHeight: this.getThemeButton().height + 'px',
                    color: this._getLabelColor() },
                overlay: {
                    transition: Transitions.easeOut(),
                    top: 0
                },
                overlayWhenHovered: {
                    backgroundColor: ColorManipulator.fade(this._getLabelColor(), amount)
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var label = _props.label;
            var primary = _props.primary;
            var secondary = _props.secondary;

            var other = _objectWithoutProperties(_props, ['label', 'primary', 'secondary']);

            var styles = this.getStyles();

            var labelElement;
            if (label) {
                labelElement = React.createElement(
                    'span',
                    { style: this.mergeAndPrefix(styles.label, this.props.labelStyle) },
                    label
                );
            }

            var rippleColor = styles.label.color;
            var rippleOpacity = !(primary || secondary) ? 0.1 : 0.16;

            return React.createElement(
                Paper,
                {
                    style: this.mergeAndPrefix(styles.root, this.props.style),
                    zDepth: this.state.zDepth },
                React.createElement(
                    EnhancedButton,
                    _extends({}, other, {
                        ref: 'container',
                        style: this.mergeAndPrefix(styles.container),
                        onMouseUp: this._handleMouseUp,
                        onMouseDown: this._handleMouseDown,
                        onMouseOut: this._handleMouseOut,
                        onMouseOver: this._handleMouseOver,
                        onTouchStart: this._handleTouchStart,
                        onTouchEnd: this._handleTouchEnd,
                        focusRippleColor: rippleColor,
                        touchRippleColor: rippleColor,
                        focusRippleOpacity: rippleOpacity,
                        touchRippleOpacity: rippleOpacity,
                        onKeyboardFocus: this._handleKeyboardFocus }),
                    React.createElement(
                        'div',
                        { ref: 'overlay', style: this.mergeAndPrefix(styles.overlay, this.state.hovered && !this.props.disabled && styles.overlayWhenHovered) },
                        labelElement,
                        this.props.children
                    )
                )
            );
        },

        _handleMouseDown: function _handleMouseDown(e) {
            //only listen to left clicks
            if (e.button === 0) {
                this.setState({ zDepth: this.state.initialZDepth + 1 });
            }
            if (this.props.onMouseDown) this.props.onMouseDown(e);
        },

        _handleMouseUp: function _handleMouseUp(e) {
            this.setState({ zDepth: this.state.initialZDepth });
            if (this.props.onMouseUp) this.props.onMouseUp(e);
        },

        _handleMouseOut: function _handleMouseOut(e) {
            if (!this.refs.container.isKeyboardFocused()) this.setState({ zDepth: this.state.initialZDepth, hovered: false });
            if (this.props.onMouseOut) this.props.onMouseOut(e);
        },

        _handleMouseOver: function _handleMouseOver(e) {
            if (!this.refs.container.isKeyboardFocused()) this.setState({ hovered: true });
            if (this.props.onMouseOver) this.props.onMouseOver(e);
        },

        _handleTouchStart: function _handleTouchStart(e) {
            this.setState({ zDepth: this.state.initialZDepth + 1 });
            if (this.props.onTouchStart) this.props.onTouchStart(e);
        },

        _handleTouchEnd: function _handleTouchEnd(e) {
            this.setState({ zDepth: this.state.initialZDepth });
            if (this.props.onTouchEnd) this.props.onTouchEnd(e);
        },

        _handleKeyboardFocus: function _handleKeyboardFocus(e, keyboardFocused) {
            if (keyboardFocused && !this.props.disabled) {
                this.setState({ zDepth: this.state.initialZDepth + 1 });
                var amount = this.props.primary || this.props.secondary ? 0.4 : 0.08;
                React.findDOMNode(this.refs.overlay).style.backgroundColor = ColorManipulator.fade(this.mergeAndPrefix(this.getStyles().label, this.props.labelStyle).color, amount);
            } else if (!this.state.hovered) {
                this.setState({ zDepth: this.state.initialZDepth });
                React.findDOMNode(this.refs.overlay).style.backgroundColor = 'transparent';
            }
        } });

    module.exports = RaisedButton;
},{"./enhanced-button":20,"./mixins/style-propable":36,"./paper":40,"./styles/transitions":55,"./styles/typography":56,"./utils/color-manipulator":91,"react":"react"}],44:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var Transitions = require('../styles/transitions');
    var Colors = require('../styles/colors');

    var RippleCircle = React.createClass({
        displayName: 'RippleCircle',

        mixins: [StylePropable],

        propTypes: {
            color: React.PropTypes.string,
            opacity: React.PropTypes.number,
            started: React.PropTypes.bool,
            ending: React.PropTypes.bool
        },

        getDefaultProps: function getDefaultProps() {
            return {
                color: Colors.darkBlack
            };
        },

        render: function render() {
            var _props = this.props;
            var color = _props.color;
            var started = _props.started;
            var ending = _props.ending;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['color', 'started', 'ending', 'style']);

            var styles = this.mergeAndPrefix({
                position: 'absolute',
                top: 0,
                left: 0,
                height: '100%',
                width: '100%',
                opacity: this.props.ending ? 0 : this.props.opacity ? this.props.opacity : 0.16,
                borderRadius: '50%',
                transform: this.props.started ? 'scale(1)' : 'scale(0)',
                backgroundColor: this.props.color,
                transition: Transitions.easeOut('2s', 'opacity') + ',' + Transitions.easeOut('1s', 'transform')
            }, this.props.style);

            return React.createElement('div', _extends({}, other, { style: styles }));
        }

    });

    module.exports = RippleCircle;
},{"../mixins/style-propable":36,"../styles/colors":50,"../styles/transitions":55,"react":"react"}],45:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var Transitions = require('../styles/transitions');
    var Colors = require('../styles/colors');
    var AutoPrefix = require('../styles/auto-prefix');

    var pulsateDuration = 750;

    var FocusRipple = React.createClass({
        displayName: 'FocusRipple',

        mixins: [StylePropable],

        propTypes: {
            color: React.PropTypes.string,
            opacity: React.PropTypes.number,
            show: React.PropTypes.bool,
            innerStyle: React.PropTypes.object
        },

        getDefaultProps: function getDefaultProps() {
            return {
                color: Colors.darkBlack
            };
        },

        componentDidMount: function componentDidMount() {
            this._setRippleSize();
            this._pulsate();
        },

        render: function render() {

            var outerStyles = this.mergeAndPrefix({
                height: '100%',
                width: '100%',
                position: 'absolute',
                top: 0,
                left: 0,
                transition: Transitions.easeOut(),
                transform: this.props.show ? 'scale(1)' : 'scale(0)',
                opacity: this.props.show ? 1 : 0
            }, this.props.style);

            var innerStyles = this.mergeAndPrefix({
                position: 'absolute',
                height: '100%',
                width: '100%',
                borderRadius: '50%',
                opacity: this.props.opacity ? this.props.opacity : 0.16,
                backgroundColor: this.props.color,
                transition: Transitions.easeOut(pulsateDuration + 'ms', null, null, Transitions.easeInOutFunction)
            }, this.props.innerStyle);

            return React.createElement(
                'div',
                { style: outerStyles },
                React.createElement('div', { ref: 'innerCircle', style: innerStyles })
            );
        },

        _pulsate: function _pulsate() {
            if (!this.isMounted() || !this.props.show) return;

            var startScale = 'scale(0.75)';
            var endScale = 'scale(0.85)';
            var innerCircle = React.findDOMNode(this.refs.innerCircle);
            var currentScale = innerCircle.style[AutoPrefix.single('transform')];
            var nextScale;

            currentScale = currentScale || startScale;
            nextScale = currentScale === startScale ? endScale : startScale;

            innerCircle.style[AutoPrefix.single('transform')] = nextScale;
            setTimeout(this._pulsate, pulsateDuration);
        },

        _setRippleSize: function _setRippleSize() {
            var el = React.findDOMNode(this);
            var height = el.offsetHeight;
            var width = el.offsetWidth;
            var size = Math.max(height, width);

            el.style.height = size + 'px';
            el.style.top = size / 2 * -1 + height / 2 + 'px';
        }

    });

    module.exports = FocusRipple;
},{"../mixins/style-propable":36,"../styles/auto-prefix":49,"../styles/colors":50,"../styles/transitions":55,"react":"react"}],46:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var Dom = require('../utils/dom');
    var RippleCircle = require('./circle');
    var TouchRipple = React.createClass({
        displayName: 'TouchRipple',

        mixins: [StylePropable],

        propTypes: {
            centerRipple: React.PropTypes.bool,
            color: React.PropTypes.string,
            opacity: React.PropTypes.number },

        getInitialState: function getInitialState() {
            return {
                ripples: [{
                    key: 0,
                    started: false,
                    ending: false
                }]
            };
        },

        render: function render() {

            var styles = this.mergeAndPrefix({
                height: '100%',
                width: '100%',
                position: 'absolute',
                top: 0,
                left: 0
            }, this.props.style);

            return React.createElement(
                'div',
                {
                    onMouseUp: this._handleMouseUp,
                    onMouseDown: this._handleMouseDown,
                    onMouseOut: this._handleMouseOut,
                    onTouchStart: this._handleTouchStart,
                    onTouchEnd: this._handleTouchEnd },
                React.createElement(
                    'div',
                    { style: styles },
                    this._getRippleElements()
                ),
                this.props.children
            );
        },

        start: function start(e, isRippleTouchGenerated) {
            var ripples = this.state.ripples;
            var nextKey = ripples[ripples.length - 1].key + 1;
            var style = !this.props.centerRipple ? this._getRippleStyle(e) : {};
            var ripple;

            //Do nothing if we're starting a click-event-generated ripple
            //while having touch-generated ripples
            if (!isRippleTouchGenerated) {
                for (var i = 0; i < ripples.length; i++) {
                    if (ripples[i].touchGenerated) return;
                }
            }

            //Start the next unstarted ripple
            for (var i = 0; i < ripples.length; i++) {
                ripple = ripples[i];
                if (!ripple.started) {
                    ripple.started = true;
                    ripple.touchGenerated = isRippleTouchGenerated;
                    ripple.style = style;
                    break;
                }
            }

            //Add an unstarted ripple at the end
            ripples.push({
                key: nextKey,
                started: false,
                ending: false
            });

            //Re-render
            this.setState({
                ripples: ripples
            });
        },

        end: function end() {
            var ripples = this.state.ripples;
            var ripple;
            var endingRipple;

            //End the the next un-ended ripple
            for (var i = 0; i < ripples.length; i++) {
                ripple = ripples[i];
                if (ripple.started && !ripple.ending) {
                    ripple.ending = true;
                    endingRipple = ripple;
                    break;
                }
            }

            //Only update if a ripple was found
            if (endingRipple) {
                //Re-render
                this.setState({
                    ripples: ripples
                });

                //Wait 2 seconds and remove the ripple from DOM
                setTimeout((function () {
                    ripples.shift();
                    if (this.isMounted()) {
                        this.setState({
                            ripples: ripples
                        });
                    }
                }).bind(this), 2000);
            }
        },

        _handleMouseDown: function _handleMouseDown(e) {
            //only listen to left clicks
            if (e.button === 0) this.start(e, false);
        },

        _handleMouseUp: function _handleMouseUp() {
            this.end();
        },

        _handleMouseOut: function _handleMouseOut() {
            this.end();
        },

        _handleTouchStart: function _handleTouchStart(e) {
            this.start(e, true);
        },

        _handleTouchEnd: function _handleTouchEnd() {
            this.end();
        },

        _getRippleStyle: function _getRippleStyle(e) {
            var style = {};
            var el = React.findDOMNode(this);
            var elHeight = el.offsetHeight;
            var elWidth = el.offsetWidth;
            var offset = Dom.offset(el);
            var isTouchEvent = e.touches && e.touches.length;
            var pageX = isTouchEvent ? e.touches[0].pageX : e.pageX;
            var pageY = isTouchEvent ? e.touches[0].pageY : e.pageY;
            var pointerX = pageX - offset.left;
            var pointerY = pageY - offset.top;
            var topLeftDiag = this._calcDiag(pointerX, pointerY);
            var topRightDiag = this._calcDiag(elWidth - pointerX, pointerY);
            var botRightDiag = this._calcDiag(elWidth - pointerX, elHeight - pointerY);
            var botLeftDiag = this._calcDiag(pointerX, elHeight - pointerY);
            var rippleRadius = Math.max(topLeftDiag, topRightDiag, botRightDiag, botLeftDiag);
            var rippleSize = rippleRadius * 2;
            var left = pointerX - rippleRadius;
            var top = pointerY - rippleRadius;

            style.height = rippleSize + 'px';
            style.width = rippleSize + 'px';
            style.top = top + 'px';
            style.left = left + 'px';

            return style;
        },

        _calcDiag: function _calcDiag(a, b) {
            return Math.sqrt(a * a + b * b);
        },

        _getRippleElements: function _getRippleElements() {
            return this.state.ripples.map((function (ripple) {
                return React.createElement(RippleCircle, {
                    key: ripple.key,
                    started: ripple.started,
                    ending: ripple.ending,
                    style: ripple.style,
                    color: this.props.color,
                    opacity: this.props.opacity });
            }).bind(this));
        }

    });

    module.exports = TouchRipple;
},{"../mixins/style-propable":36,"../utils/dom":94,"./circle":44,"react":"react"}],47:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Draggable = require('react-draggable2');
    var Transitions = require('./styles/transitions.js');
    var FocusRipple = require('./ripples/focus-ripple');

    var Slider = React.createClass({
        displayName: 'Slider',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            required: React.PropTypes.bool,
            disabled: React.PropTypes.bool,
            min: React.PropTypes.number,
            max: React.PropTypes.number,
            step: React.PropTypes.number,
            error: React.PropTypes.string,
            description: React.PropTypes.string,
            name: React.PropTypes.string.isRequired,
            onChange: React.PropTypes.func,
            onFocus: React.PropTypes.func,
            onBlur: React.PropTypes.func,
            onDragStart: React.PropTypes.func,
            onDragStop: React.PropTypes.func
        },

        getDefaultProps: function getDefaultProps() {
            return {
                required: true,
                disabled: false,
                defaultValue: 0,
                min: 0,
                max: 1,
                dragging: false
            };
        },

        getInitialState: function getInitialState() {
            var value = this.props.value;
            if (value == null) value = this.props.defaultValue;
            var percent = (value - this.props.min) / (this.props.max - this.props.min);
            if (isNaN(percent)) percent = 0;
            return {
                value: value,
                percent: percent,
                focused: false,
                active: false,
                hovered: false
            };
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            if (nextProps.value != null) {
                this.setValue(nextProps.value);
            }
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.slider;
        },

        getStyles: function getStyles() {
            var size = this.getTheme().handleSize + this.getTheme().trackSize;
            var gutter = (this.getTheme().handleSizeDisabled + this.getTheme().trackSize) / 2;
            var fillGutter = this.getTheme().handleSizeDisabled - this.getTheme().trackSize;
            var styles = {
                root: {
                    touchCallout: 'none',
                    userSelect: 'none',
                    cursor: 'default',
                    height: this.getTheme().handleSizeActive,
                    position: 'relative',
                    marginTop: 24,
                    marginBottom: 48
                },
                track: {
                    position: 'absolute',
                    top: (this.getTheme().handleSizeActive - this.getTheme().trackSize) / 2,
                    left: 0,
                    width: '100%',
                    height: this.getTheme().trackSize
                },
                filledAndRemaining: {
                    position: 'absolute',
                    top: 0,
                    height: '100%',
                    transition: Transitions.easeOut(null, 'margin') },
                percentZeroRemaining: {
                    left: 1,
                    marginLeft: gutter
                },
                handle: {
                    boxSizing: 'border-box',
                    position: 'absolute',
                    cursor: 'pointer',
                    pointerEvents: 'inherit',
                    top: (this.getTheme().handleSizeActive - this.getTheme().trackSize) / 2 + 'px',
                    left: '0%',
                    zIndex: 1,
                    margin: this.getTheme().trackSize / 2 + 'px 0 0 0',
                    width: this.getTheme().handleSize,
                    height: this.getTheme().handleSize,
                    backgroundColor: this.getTheme().selectionColor,
                    backgroundClip: 'padding-box',
                    border: '0px solid transparent',
                    borderRadius: '50%',
                    transform: 'translate(-50%, -50%)',
                    transition: Transitions.easeOut('450ms', 'border') + ',' + Transitions.easeOut('450ms', 'width') + ',' + Transitions.easeOut('450ms', 'height'),
                    overflow: 'visible'
                },
                handleWhenDisabled: {
                    boxSizing: 'content-box',
                    cursor: 'not-allowed',
                    backgroundColor: this.getTheme().trackColor,
                    width: this.getTheme().handleSizeDisabled,
                    height: this.getTheme().handleSizeDisabled,
                    border: '2px solid white'
                },
                handleWhenPercentZero: {
                    border: this.getTheme().trackSize + 'px solid ' + this.getTheme().trackColor,
                    backgroundColor: this.getTheme().handleFillColor,
                    boxShadow: 'none'
                },
                handleWhenActive: {
                    borderColor: this.getTheme().trackColorSelected,
                    width: this.getTheme().handleSizeActive,
                    height: this.getTheme().handleSizeActive,
                    transition: Transitions.easeOut('450ms', 'backgroundColor') + ',' + Transitions.easeOut('450ms', 'width') + ',' + Transitions.easeOut('450ms', 'height')
                },
                ripples: {
                    height: '300%',
                    width: '300%',
                    top: '-12px',
                    left: '-12px'
                },
                handleWhenDisabledAndZero: {
                    width: size / 2 + 'px',
                    height: size / 2 + 'px'
                },
                handleWhenPercentZeroAndHovered: {
                    border: this.getTheme().trackSize + 'px solid ' + this.getTheme().handleColorZero,
                    width: size + 'px',
                    height: size + 'px'
                } };
            styles.filled = this.mergeAndPrefix(styles.filledAndRemaining, {
                left: 0,
                backgroundColor: this.props.disabled ? this.getTheme().trackColor : this.getTheme().selectionColor,
                marginRight: fillGutter,
                width: this.state.percent * 100 + (this.props.disabled ? -1 : 0) + '%'
            });
            styles.remaining = this.mergeAndPrefix(styles.filledAndRemaining, {
                right: 0,
                backgroundColor: this.getTheme().trackColor,
                marginLeft: fillGutter,
                width: (1 - this.state.percent) * 100 + (this.props.disabled ? -1 : 0) + '%'
            });

            styles.percentZeroRemaining.width = styles.remaining.width - styles.percentZeroRemaining.left;

            return styles;
        },

        render: function render() {
            var percent = this.state.percent;
            if (percent > 1) percent = 1;else if (percent < 0) percent = 0;
            var gutter = (this.getTheme().handleSizeDisabled + this.getTheme().trackSize) / 2;
            var fillGutter = this.getTheme().handleSizeDisabled - this.getTheme().trackSize;

            var styles = this.getStyles();
            var sliderStyles = this.mergeAndPrefix(styles.root, this.props.style);
            var trackStyles = styles.track;
            var filledStyles = styles.filled;
            var remainingStyles = this.mergeAndPrefix(styles.remaining, percent === 0 && styles.percentZeroRemaining);
            var handleStyles = percent === 0 ? this.mergeAndPrefix(styles.handle, styles.handleWhenPercentZero, this.state.active && styles.handleWhenActive, this.state.focused && { outline: 'none' }, this.state.hovered && styles.handleWhenPercentZeroAndHovered, this.props.disabled && styles.handleWhenDisabledAndZero) : this.mergeAndPrefix(styles.handle, this.state.active && styles.handleWhenActive, this.state.focused && { outline: 'none' }, this.props.disabled && styles.handleWhenDisabled);

            var rippleStyle = { height: '12px', width: '12px' };

            if ((this.state.hovered || this.state.focused) && !this.props.disabled) {
                remainingStyles.backgroundColor = this.getTheme().trackColorSelected;
            }

            if (percent === 0) filledStyles.marginRight = gutter;
            if (this.state.percent === 0 && this.state.active) remainingStyles.marginLeft = fillGutter;

            var rippleShowCondition = (this.state.hovered || this.state.focused) && !this.state.active && this.state.percent !== 0;
            var rippleColor = this.state.percent === 0 ? this.getTheme().handleColorZero : this.getTheme().rippleColor;
            var focusRipple;
            if (!this.props.disabled && !this.props.disableFocusRipple) {
                focusRipple = React.createElement(FocusRipple, {
                    ref: 'focusRipple',
                    key: 'focusRipple',
                    style: rippleStyle,
                    innerStyle: styles.ripples,
                    show: rippleShowCondition,
                    color: rippleColor });
            }

            return React.createElement(
                'div',
                { style: this.props.style },
                React.createElement('span', { className: 'mui-input-highlight' }),
                React.createElement('span', { className: 'mui-input-bar' }),
                React.createElement(
                    'span',
                    { className: 'mui-input-description' },
                    this.props.description
                ),
                React.createElement(
                    'span',
                    { className: 'mui-input-error' },
                    this.props.error
                ),
                React.createElement(
                    'div',
                    { style: sliderStyles,
                        onTouchTap: this._onClick,
                        onFocus: this._onFocus,
                        onBlur: this._onBlur,
                        onMouseOver: this._onMouseOver,
                        onMouseOut: this._onMouseOut,
                        onMouseUp: this._onMouseUp },
                    React.createElement(
                        'div',
                        { ref: 'track', style: trackStyles },
                        React.createElement('div', { style: filledStyles }),
                        React.createElement('div', { style: remainingStyles }),
                        React.createElement(
                            Draggable,
                            { axis: 'x', bound: 'point',
                                cancel: this.props.disabled ? '*' : null,
                                start: { x: percent * 100 + '%' },
                                onStart: this._onDragStart,
                                onStop: this._onDragStop,
                                onDrag: this._onDragUpdate,
                                onMouseDown: this._onMouseDown },
                            React.createElement(
                                'div',
                                { style: handleStyles, tabIndex: 0 },
                                focusRipple
                            )
                        )
                    )
                ),
                React.createElement('input', { ref: 'input', type: 'hidden',
                    name: this.props.name,
                    value: this.state.value,
                    required: this.props.required,
                    min: this.props.min,
                    max: this.props.max,
                    step: this.props.step })
            );
        },

        getValue: function getValue() {
            return this.state.value;
        },

        setValue: function setValue(i) {
            // calculate percentage
            var percent = (i - this.props.min) / (this.props.max - this.props.min);
            if (isNaN(percent)) percent = 0;
            // update state
            this.setState({
                value: i,
                percent: percent
            });
        },

        getPercent: function getPercent() {
            return this.state.percent;
        },

        setPercent: function setPercent(percent) {
            var value = this._percentToValue(percent);
            this.setState({ value: value, percent: percent });
        },

        clearValue: function clearValue() {
            this.setValue(0);
        },

        _onClick: function _onClick(e) {
            this._tabPressed = false;
            // let draggable handle the slider
            if (this.state.dragging || this.props.disabled) return;
            var node = React.findDOMNode(this.refs.track);
            var boundingClientRect = node.getBoundingClientRect();
            var offset = e.clientX - boundingClientRect.left;
            this._updateWithChangeEvent(e, offset / node.clientWidth);
        },

        _onFocus: function _onFocus(e) {
            this.setState({ focused: true });
            if (this.props.onFocus) this.props.onFocus(e);
        },

        _onBlur: function _onBlur(e) {
            this.setState({ focused: false, active: false });
            if (this.props.onBlur) this.props.onBlur(e);
        },

        _onMouseOver: function _onMouseOver() {
            this.setState({ hovered: true });
        },

        _onMouseOut: function _onMouseOut() {
            this.setState({ hovered: false });
        },

        _onMouseUp: function _onMouseUp() {
            if (!this.props.disabled) this.setState({ active: false });
        },

        _onMouseDown: function _onMouseDown() {
            if (!this.props.disabled) this.setState({ active: true });
        },

        _onDragStart: function _onDragStart(e, ui) {
            this.setState({
                dragging: true,
                active: true
            });
            if (this.props.onDragStart) this.props.onDragStart(e, ui);
        },

        _onDragStop: function _onDragStop(e, ui) {
            this.setState({
                dragging: false,
                active: false
            });
            if (this.props.onDragStop) this.props.onDragStop(e, ui);
        },

        _onDragUpdate: function _onDragUpdate(e, ui) {
            if (!this.state.dragging) return;
            if (!this.props.disabled) this._dragX(e, ui.position.left);
        },

        _dragX: function _dragX(e, pos) {
            var max = React.findDOMNode(this.refs.track).clientWidth;
            if (pos < 0) pos = 0;else if (pos > max) pos = max;
            this._updateWithChangeEvent(e, pos / max);
        },

        _updateWithChangeEvent: function _updateWithChangeEvent(e, percent) {
            if (this.state.percent === percent) return;
            this.setPercent(percent);
            var value = this._percentToValue(percent);
            if (this.props.onChange) this.props.onChange(e, value);
        },

        _percentToValue: function _percentToValue(percent) {
            return percent * (this.props.max - this.props.min) + this.props.min;
        }

    });

    module.exports = Slider;
},{"./mixins/style-propable":36,"./ripples/focus-ripple":45,"./styles/transitions.js":55,"react":"react","react-draggable2":102}],48:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var CssEvent = require('./utils/css-event');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var ClickAwayable = require('./mixins/click-awayable');
    var FlatButton = require('./flat-button');

    var Snackbar = React.createClass({
        displayName: 'Snackbar',

        mixins: [StylePropable, ClickAwayable],

        manuallyBindClickAway: true,

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            action: React.PropTypes.string,
            message: React.PropTypes.string.isRequired,
            openOnMount: React.PropTypes.bool,
            onActionTouchTap: React.PropTypes.func
        },

        getInitialState: function getInitialState() {
            return {
                open: this.props.openOnMount || false
            };
        },

        componentClickAway: function componentClickAway() {
            this.dismiss();
        },

        componentDidUpdate: function componentDidUpdate(prevProps, prevState) {
            if (prevState.open != this.state.open) {
                if (this.state.open) {
                    //Only Bind clickaway after transition finishes
                    CssEvent.onTransitionEnd(React.findDOMNode(this), (function () {
                        this._bindClickAway();
                    }).bind(this));
                } else {
                    this._unbindClickAway();
                }
            }
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.snackbar;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    color: this.getTheme().textColor,
                    backgroundColor: this.getTheme().backgroundColor,
                    borderRadius: 2,
                    padding: '0px ' + this.getSpacing().desktopGutter + 'px',
                    height: this.getSpacing().desktopSubheaderHeight,
                    lineHeight: this.getSpacing().desktopSubheaderHeight + 'px',
                    minWidth: 288,
                    maxWidth: 568,

                    position: 'fixed',
                    zIndex: 10,
                    bottom: this.getSpacing().desktopGutter,
                    marginLeft: this.getSpacing().desktopGutter,

                    left: -10000,
                    opacity: 0,
                    transform: 'translate3d(0, 20px, 0)',
                    transition: Transitions.easeOut('0ms', 'left', '400ms') + ',' + Transitions.easeOut('400ms', 'opacity') + ',' + Transitions.easeOut('400ms', 'transform') },
                action: {
                    color: this.getTheme().actionColor,
                    float: 'right',
                    marginTop: 6,
                    marginRight: -16,
                    marginLeft: this.getSpacing().desktopGutter,
                    backgroundColor: 'transparent'
                },
                rootWhenOpen: {
                    left: '0px',
                    opacity: 1,
                    transform: 'translate3d(0, 0, 0)',
                    transition: Transitions.easeOut('0ms', 'left', '0ms') + ',' + Transitions.easeOut('400ms', 'opacity', '0ms') + ',' + Transitions.easeOut('400ms', 'transform', '0ms')
                }
            };
            return styles;
        },

        render: function render() {

            var styles = this.getStyles();

            var action;
            if (this.props.action) {
                action = React.createElement(FlatButton, {
                    style: styles.action,
                    label: this.props.action,
                    onTouchTap: this.props.onActionTouchTap });
            }

            var rootStyles = styles.root;
            if (this.state.open) rootStyles = this.mergeStyles(styles.root, styles.rootWhenOpen, this.props.style);

            return React.createElement(
                'span',
                { style: rootStyles },
                React.createElement(
                    'span',
                    null,
                    this.props.message
                ),
                action
            );
        },

        show: function show() {
            this.setState({ open: true });
        },

        dismiss: function dismiss() {
            this.setState({ open: false });
        }

    });

    module.exports = Snackbar;
},{"./flat-button":23,"./mixins/click-awayable":35,"./mixins/style-propable":36,"./styles/transitions":55,"./utils/css-event":92,"react":"react"}],49:[function(require,module,exports){
    'use strict';

    var isBrowser = typeof window !== 'undefined';
    var Modernizr = isBrowser ? require('../utils/modernizr.custom') : undefined;

    module.exports = {

        all: function all(styles) {
            var prefixedStyle = {};
            for (var key in styles) {
                prefixedStyle[this.single(key)] = styles[key];
            }
            return prefixedStyle;
        },

        set: function set(style, key, value) {
            style[this.single(key)] = value;
        },

        single: function single(key) {
            return isBrowser ? Modernizr.prefixed(key) : key;
        },

        singleHyphened: function singleHyphened(key) {
            var str = this.single(key);

            return !str ? key : str.replace(/([A-Z])/g, function (str, m1) {
                return '-' + m1.toLowerCase();
            }).replace(/^ms-/, '-ms-');
        }

    };
},{"../utils/modernizr.custom":99}],50:[function(require,module,exports){
// To include this file in your project:
// var mui = require('mui');
// var Colors = mui.Styles.Colors;

    'use strict';

    module.exports = {

        red50: '#ffebee',
        red100: '#ffcdd2',
        red200: '#ef9a9a',
        red300: '#e57373',
        red400: '#ef5350',
        red500: '#f44336',
        red600: '#e53935',
        red700: '#d32f2f',
        red800: '#c62828',
        red900: '#b71c1c',
        redA100: '#ff8a80',
        redA200: '#ff5252',
        redA400: '#ff1744',
        redA700: '#d50000',

        pink50: '#fce4ec',
        pink100: '#f8bbd0',
        pink200: '#f48fb1',
        pink300: '#f06292',
        pink400: '#ec407a',
        pink500: '#e91e63',
        pink600: '#d81b60',
        pink700: '#c2185b',
        pink800: '#ad1457',
        pink900: '#880e4f',
        pinkA100: '#ff80ab',
        pinkA200: '#ff4081',
        pinkA400: '#f50057',
        pinkA700: '#c51162',

        purple50: '#f3e5f5',
        purple100: '#e1bee7',
        purple200: '#ce93d8',
        purple300: '#ba68c8',
        purple400: '#ab47bc',
        purple500: '#9c27b0',
        purple600: '#8e24aa',
        purple700: '#7b1fa2',
        purple800: '#6a1b9a',
        purple900: '#4a148c',
        purpleA100: '#ea80fc',
        purpleA200: '#e040fb',
        purpleA400: '#d500f9',
        purpleA700: '#aa00ff',

        deepPurple50: '#ede7f6',
        deepPurple100: '#d1c4e9',
        deepPurple200: '#b39ddb',
        deepPurple300: '#9575cd',
        deepPurple400: '#7e57c2',
        deepPurple500: '#673ab7',
        deepPurple600: '#5e35b1',
        deepPurple700: '#512da8',
        deepPurple800: '#4527a0',
        deepPurple900: '#311b92',
        deepPurpleA100: '#b388ff',
        deepPurpleA200: '#7c4dff',
        deepPurpleA400: '#651fff',
        deepPurpleA700: '#6200ea',

        indigo50: '#e8eaf6',
        indigo100: '#c5cae9',
        indigo200: '#9fa8da',
        indigo300: '#7986cb',
        indigo400: '#5c6bc0',
        indigo500: '#3f51b5',
        indigo600: '#3949ab',
        indigo700: '#303f9f',
        indigo800: '#283593',
        indigo900: '#1a237e',
        indigoA100: '#8c9eff',
        indigoA200: '#536dfe',
        indigoA400: '#3d5afe',
        indigoA700: '#304ffe',

        blue50: '#e3f2fd',
        blue100: '#bbdefb',
        blue200: '#90caf9',
        blue300: '#64b5f6',
        blue400: '#42a5f5',
        blue500: '#2196f3',
        blue600: '#1e88e5',
        blue700: '#1976d2',
        blue800: '#1565c0',
        blue900: '#0d47a1',
        blueA100: '#82b1ff',
        blueA200: '#448aff',
        blueA400: '#2979ff',
        blueA700: '#2962ff',

        lightBlue50: '#e1f5fe',
        lightBlue100: '#b3e5fc',
        lightBlue200: '#81d4fa',
        lightBlue300: '#4fc3f7',
        lightBlue400: '#29b6f6',
        lightBlue500: '#03a9f4',
        lightBlue600: '#039be5',
        lightBlue700: '#0288d1',
        lightBlue800: '#0277bd',
        lightBlue900: '#01579b',
        lightBlueA100: '#80d8ff',
        lightBlueA200: '#40c4ff',
        lightBlueA400: '#00b0ff',
        lightBlueA700: '#0091ea',

        cyan50: '#e0f7fa',
        cyan100: '#b2ebf2',
        cyan200: '#80deea',
        cyan300: '#4dd0e1',
        cyan400: '#26c6da',
        cyan500: '#00bcd4',
        cyan600: '#00acc1',
        cyan700: '#0097a7',
        cyan800: '#00838f',
        cyan900: '#006064',
        cyanA100: '#84ffff',
        cyanA200: '#18ffff',
        cyanA400: '#00e5ff',
        cyanA700: '#00b8d4',

        teal50: '#e0f2f1',
        teal100: '#b2dfdb',
        teal200: '#80cbc4',
        teal300: '#4db6ac',
        teal400: '#26a69a',
        teal500: '#009688',
        teal600: '#00897b',
        teal700: '#00796b',
        teal800: '#00695c',
        teal900: '#004d40',
        tealA100: '#a7ffeb',
        tealA200: '#64ffda',
        tealA400: '#1de9b6',
        tealA700: '#00bfa5',

        green50: '#e8f5e9',
        green100: '#c8e6c9',
        green200: '#a5d6a7',
        green300: '#81c784',
        green400: '#66bb6a',
        green500: '#4caf50',
        green600: '#43a047',
        green700: '#388e3c',
        green800: '#2e7d32',
        green900: '#1b5e20',
        greenA100: '#b9f6ca',
        greenA200: '#69f0ae',
        greenA400: '#00e676',
        greenA700: '#00c853',

        lightGreen50: '#f1f8e9',
        lightGreen100: '#dcedc8',
        lightGreen200: '#c5e1a5',
        lightGreen300: '#aed581',
        lightGreen400: '#9ccc65',
        lightGreen500: '#8bc34a',
        lightGreen600: '#7cb342',
        lightGreen700: '#689f38',
        lightGreen800: '#558b2f',
        lightGreen900: '#33691e',
        lightGreenA100: '#ccff90',
        lightGreenA200: '#b2ff59',
        lightGreenA400: '#76ff03',
        lightGreenA700: '#64dd17',

        lime50: '#f9fbe7',
        lime100: '#f0f4c3',
        lime200: '#e6ee9c',
        lime300: '#dce775',
        lime400: '#d4e157',
        lime500: '#cddc39',
        lime600: '#c0ca33',
        lime700: '#afb42b',
        lime800: '#9e9d24',
        lime900: '#827717',
        limeA100: '#f4ff81',
        limeA200: '#eeff41',
        limeA400: '#c6ff00',
        limeA700: '#aeea00',

        yellow50: '#fffde7',
        yellow100: '#fff9c4',
        yellow200: '#fff59d',
        yellow300: '#fff176',
        yellow400: '#ffee58',
        yellow500: '#ffeb3b',
        yellow600: '#fdd835',
        yellow700: '#fbc02d',
        yellow800: '#f9a825',
        yellow900: '#f57f17',
        yellowA100: '#ffff8d',
        yellowA200: '#ffff00',
        yellowA400: '#ffea00',
        yellowA700: '#ffd600',

        amber50: '#fff8e1',
        amber100: '#ffecb3',
        amber200: '#ffe082',
        amber300: '#ffd54f',
        amber400: '#ffca28',
        amber500: '#ffc107',
        amber600: '#ffb300',
        amber700: '#ffa000',
        amber800: '#ff8f00',
        amber900: '#ff6f00',
        amberA100: '#ffe57f',
        amberA200: '#ffd740',
        amberA400: '#ffc400',
        amberA700: '#ffab00',

        orange50: '#fff3e0',
        orange100: '#ffe0b2',
        orange200: '#ffcc80',
        orange300: '#ffb74d',
        orange400: '#ffa726',
        orange500: '#ff9800',
        orange600: '#fb8c00',
        orange700: '#f57c00',
        orange800: '#ef6c00',
        orange900: '#e65100',
        orangeA100: '#ffd180',
        orangeA200: '#ffab40',
        orangeA400: '#ff9100',
        orangeA700: '#ff6d00',

        deepOrange50: '#fbe9e7',
        deepOrange100: '#ffccbc',
        deepOrange200: '#ffab91',
        deepOrange300: '#ff8a65',
        deepOrange400: '#ff7043',
        deepOrange500: '#ff5722',
        deepOrange600: '#f4511e',
        deepOrange700: '#e64a19',
        deepOrange800: '#d84315',
        deepOrange900: '#bf360c',
        deepOrangeA100: '#ff9e80',
        deepOrangeA200: '#ff6e40',
        deepOrangeA400: '#ff3d00',
        deepOrangeA700: '#dd2c00',

        brown50: '#efebe9',
        brown100: '#d7ccc8',
        brown200: '#bcaaa4',
        brown300: '#a1887f',
        brown400: '#8d6e63',
        brown500: '#795548',
        brown600: '#6d4c41',
        brown700: '#5d4037',
        brown800: '#4e342e',
        brown900: '#3e2723',

        blueGrey50: '#eceff1',
        blueGrey100: '#cfd8dc',
        blueGrey200: '#b0bec5',
        blueGrey300: '#90a4ae',
        blueGrey400: '#78909c',
        blueGrey500: '#607d8b',
        blueGrey600: '#546e7a',
        blueGrey700: '#455a64',
        blueGrey800: '#37474f',
        blueGrey900: '#263238',

        grey50: '#fafafa',
        grey100: '#f5f5f5',
        grey200: '#eeeeee',
        grey300: '#e0e0e0',
        grey400: '#bdbdbd',
        grey500: '#9e9e9e',
        grey600: '#757575',
        grey700: '#616161',
        grey800: '#424242',
        grey900: '#212121',

        black: '#000000',
        white: '#ffffff',

        transparent: 'rgba(0, 0, 0, 0)',
        fullBlack: 'rgba(0, 0, 0, 1)',
        darkBlack: 'rgba(0, 0, 0, 0.87)',
        lightBlack: 'rgba(0, 0, 0, 0.54)',
        minBlack: 'rgba(0, 0, 0, 0.26)',
        faintBlack: 'rgba(0, 0, 0, 0.12)',
        fullWhite: 'rgba(255, 255, 255, 1)',
        darkWhite: 'rgba(255, 255, 255, 0.87)',
        lightWhite: 'rgba(255, 255, 255, 0.54)'

    };
},{}],51:[function(require,module,exports){
    "use strict";

    module.exports = {
        iconSize: 24,

        desktopGutter: 24,
        desktopGutterMore: 32,
        desktopGutterLess: 16,
        desktopGutterMini: 8,
        desktopKeylineIncrement: 64,
        desktopDropDownMenuItemHeight: 32,
        desktopDropDownMenuFontSize: 15,
        desktopLeftNavMenuItemHeight: 48,
        desktopSubheaderHeight: 48,
        desktopToolbarHeight: 56
    };
},{}],52:[function(require,module,exports){
    'use strict';

    var Spacing = require('./spacing');
    var Extend = require('../utils/extend');

    var Types = {
        LIGHT: require('./themes/light-theme'),
        DARK: require('./themes/dark-theme')
    };

    var ThemeManager = function ThemeManager() {
        return {
            types: Types,
            template: Types.LIGHT,

            spacing: Spacing,
            contentFontFamily: 'Roboto, sans-serif',

            palette: Types.LIGHT.getPalette(),
            component: Types.LIGHT.getComponentThemes(Types.LIGHT.getPalette()),

            getCurrentTheme: function getCurrentTheme() {
                return this;
            },

            // Component gets updated to reflect palette changes.
            setTheme: function setTheme(newTheme) {
                this.setPalette(newTheme.getPalette());
                this.setComponentThemes(newTheme.getComponentThemes(newTheme.getPalette()));
            },

            setPalette: function setPalette(newPalette) {
                this.palette = Extend(this.palette, newPalette);
                this.component = Extend(this.component, this.template.getComponentThemes(this.palette));
            },

            setComponentThemes: function setComponentThemes(overrides) {
                this.component = Extend(this.component, overrides);
            }
        };
    };

    module.exports = ThemeManager;
},{"../utils/extend":96,"./spacing":51,"./themes/dark-theme":53,"./themes/light-theme":54}],53:[function(require,module,exports){
    'use strict';

    var Colors = require('../colors');
    var ColorManipulator = require('../../utils/color-manipulator');

    var DarkTheme = {
        getPalette: function getPalette() {
            return {
                textColor: Colors.fullWhite,
                canvasColor: '#303030',
                borderColor: ColorManipulator.fade(Colors.fullWhite, 0.3), //Colors.grey300
                disabledColor: ColorManipulator.fade(Colors.fullWhite, 0.3)
            };
        },
        getComponentThemes: function getComponentThemes(palette) {
            var cardColor = Colors.grey800;
            return {
                floatingActionButton: {
                    disabledColor: ColorManipulator.fade(palette.textColor, 0.12) },
                leftNav: {
                    color: cardColor
                },
                menu: {
                    backgroundColor: cardColor,
                    containerBackgroundColor: cardColor
                },
                menuItem: {
                    hoverColor: 'rgba(255, 255, 255, .03)' },
                menuSubheader: {
                    borderColor: 'rgba(255, 255, 255, 0.3)' },
                paper: {
                    backgroundColor: cardColor
                },
                raisedButton: {
                    color: Colors.grey500 },
                toggle: {
                    thumbOnColor: Colors.cyan200,
                    thumbOffColor: Colors.grey400,
                    thumbDisabledColor: Colors.grey800,
                    thumbRequiredColor: Colors.cyan200,
                    trackOnColor: ColorManipulator.fade(Colors.cyan200, 0.5),
                    trackOffColor: 'rgba(255, 255, 255, 0.3)',
                    trackDisabledColor: 'rgba(255, 255, 255, 0.1)' },
                slider: {
                    trackColor: Colors.minBlack,
                    handleColorZero: cardColor,
                    handleFillColor: cardColor,
                    selectionColor: Colors.cyan200 } };
        }
    };

    module.exports = DarkTheme;
},{"../../utils/color-manipulator":91,"../colors":50}],54:[function(require,module,exports){
    'use strict';

    var Colors = require('../colors');
    var Spacing = require('../spacing');
    var ColorManipulator = require('../../utils/color-manipulator');

    /**
     *  Light Theme is the default theme used in material-ui. It is guaranteed to
     *  have all theme variables needed for every component. Variables not defined
     *  in a custom theme will default to these values.
     */

    var LightTheme = {
        spacing: Spacing,
        contentFontFamily: 'Roboto, sans-serif',
        getPalette: function getPalette() {
            return {
                primary1Color: Colors.cyan500,
                primary2Color: Colors.cyan700,
                primary3Color: Colors.cyan100,
                accent1Color: Colors.pinkA200,
                accent2Color: Colors.pinkA400,
                accent3Color: Colors.pinkA100,
                textColor: Colors.darkBlack,
                canvasColor: Colors.white,
                borderColor: Colors.grey300,
                disabledColor: ColorManipulator.fade(Colors.darkBlack, 0.3)
            };
        },
        getComponentThemes: function getComponentThemes(palette) {
            var obj = {
                appBar: {
                    color: palette.primary1Color,
                    textColor: Colors.darkWhite,
                    height: Spacing.desktopKeylineIncrement
                },
                button: {
                    height: 36,
                    minWidth: 88,
                    iconButtonSize: Spacing.iconSize * 2
                },
                checkbox: {
                    boxColor: palette.textColor,
                    checkedColor: palette.primary1Color,
                    requiredColor: palette.primary1Color,
                    disabledColor: palette.disabledColor
                },
                datePicker: {
                    color: palette.primary1Color,
                    textColor: Colors.white,
                    calendarTextColor: palette.textColor,
                    selectColor: palette.primary2Color,
                    selectTextColor: Colors.white
                },
                dropDownMenu: {
                    accentColor: palette.borderColor
                },
                flatButton: {
                    color: palette.canvasColor,
                    textColor: palette.textColor,
                    primaryTextColor: palette.accent1Color,
                    secondaryTextColor: palette.primary1Color },
                floatingActionButton: {
                    buttonSize: 56,
                    miniSize: 40,
                    color: palette.accent1Color,
                    iconColor: Colors.white,
                    secondaryColor: palette.primary1Color,
                    secondaryIconColor: Colors.white },
                leftNav: {
                    width: Spacing.desktopKeylineIncrement * 4,
                    color: Colors.white
                },
                menu: {
                    backgroundColor: Colors.white,
                    containerBackgroundColor: Colors.white },
                menuItem: {
                    dataHeight: 32,
                    height: 48,
                    hoverColor: 'rgba(0, 0, 0, .035)',
                    padding: Spacing.desktopGutter,
                    selectedTextColor: palette.accent1Color },
                menuSubheader: {
                    padding: Spacing.desktopGutter,
                    borderColor: palette.borderColor,
                    textColor: palette.primary1Color
                },
                paper: {
                    backgroundColor: Colors.white },
                radioButton: {
                    borderColor: palette.textColor,
                    backgroundColor: Colors.white,
                    checkedColor: palette.primary1Color,
                    requiredColor: palette.primary1Color,
                    disabledColor: palette.disabledColor,
                    size: 24 },
                raisedButton: {
                    color: Colors.white,
                    textColor: palette.textColor,
                    primaryColor: palette.accent1Color,
                    primaryTextColor: Colors.white,
                    secondaryColor: palette.primary1Color,
                    secondaryTextColor: Colors.white
                },
                slider: {
                    trackSize: 2,
                    trackColor: Colors.minBlack,
                    trackColorSelected: Colors.grey500,
                    handleSize: 12,
                    handleSizeDisabled: 8,
                    handleColorZero: Colors.grey400,
                    handleFillColor: Colors.white,
                    selectionColor: palette.primary3Color,
                    rippleColor: palette.primary1Color
                },
                snackbar: {
                    textColor: Colors.white,
                    backgroundColor: '#323232',
                    actionColor: palette.accent1Color
                },
                timePicker: {
                    color: Colors.white,
                    textColor: Colors.grey600,
                    accentColor: palette.primary1Color,
                    clockColor: Colors.black,
                    selectColor: palette.primary2Color,
                    selectTextColor: Colors.white
                },
                toggle: {
                    thumbOnColor: palette.primary1Color,
                    thumbOffColor: Colors.grey50,
                    thumbDisabledColor: Colors.grey400,
                    thumbRequiredColor: palette.primary1Color,
                    trackOnColor: ColorManipulator.fade(palette.primary1Color, 0.5),
                    trackOffColor: Colors.minBlack,
                    trackDisabledColor: Colors.faintBlack
                },
                toolbar: {
                    backgroundColor: ColorManipulator.darken('#eeeeee', 0.05),
                    height: 56,
                    titleFontSize: 20,
                    iconColor: 'rgba(0, 0, 0, .40)',
                    separatorColor: 'rgba(0, 0, 0, .175)',
                    menuHoverColor: 'rgba(0, 0, 0, .10)'
                },
                tabs: {
                    backgroundColor: palette.primary1Color }
            };

            // Properties based on previous properties
            obj.flatButton.disabledTextColor = ColorManipulator.fade(obj.flatButton.textColor, 0.3), obj.floatingActionButton.disabledColor = ColorManipulator.darken(Colors.white, 0.1), obj.floatingActionButton.disabledTextColor = ColorManipulator.fade(palette.textColor, 0.3);
            obj.raisedButton.disabledColor = ColorManipulator.darken(obj.raisedButton.color, 0.1), obj.raisedButton.disabledTextColor = ColorManipulator.fade(obj.raisedButton.textColor, 0.3);
            obj.slider.handleSizeActive = obj.slider.handleSize * 2;
            obj.toggle.trackRequiredColor = ColorManipulator.fade(obj.toggle.thumbRequiredColor, 0.5);

            return obj;
        }
    };

    module.exports = LightTheme;
},{"../../utils/color-manipulator":91,"../colors":50,"../spacing":51}],55:[function(require,module,exports){
    'use strict';

    var AutoPrefix = require('./auto-prefix');

    module.exports = {

        easeOutFunction: 'cubic-bezier(0.23, 1, 0.32, 1)',
        easeInOutFunction: 'cubic-bezier(0.445, 0.05, 0.55, 0.95)',

        easeOut: function easeOut(duration, property, delay, easeFunction) {

            easeFunction = easeFunction || this.easeOutFunction;

            return this.create(duration, property, delay, easeFunction);
        },

        create: function create(duration, property, delay, easeFunction) {

            duration = duration || '450ms';
            property = property || 'all';
            delay = delay || '0ms';
            easeFunction = easeFunction || 'linear';

            return AutoPrefix.singleHyphened(property) + ' ' + duration + ' ' + easeFunction + ' ' + delay;
        }
    };
},{"./auto-prefix":49}],56:[function(require,module,exports){
    'use strict';

    var Colors = require('./colors');

    var Typography = function Typography() {

        // text colors
        this.textFullBlack = Colors.fullBlack;
        this.textDarkBlack = Colors.darkBlack;
        this.textLightBlack = Colors.lightBlack;
        this.textMinBlack = Colors.minBlack;
        this.textFullWhite = Colors.fullWhite;
        this.textDarkWhite = Colors.darkWhite;
        this.textLightWhite = Colors.lightWhite;

        // font weight
        this.fontWeightLight = 300;
        this.fontWeightNormal = 400;
        this.fontWeightMedium = 500;

        this.fontStyleButtonFontSize = 14;
    };

    module.exports = new Typography();
},{"./colors":50}],57:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react/addons');
    var StylePropable = require('./mixins/style-propable');

    var SvgIcon = React.createClass({
        displayName: 'SvgIcon',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            viewBox: React.PropTypes.string
        },

        getDefaultProps: function getDefaultProps() {
            return {
                viewBox: '0 0 24 24'
            };
        },

        render: function render() {
            var _props = this.props;
            var viewBox = _props.viewBox;
            var style = _props.style;

            var other = _objectWithoutProperties(_props, ['viewBox', 'style']);

            var mergedStyles = this.mergeAndPrefix({
                display: 'inline-block',
                height: '24px',
                width: '24px',
                userSelect: 'none',
                fill: this.context.muiTheme.palette.textColor
            }, style);

            return React.createElement(
                'svg',
                _extends({}, other, {
                    viewBox: viewBox,
                    style: mergedStyles }),
                this.props.children
            );
        }
    });

    module.exports = SvgIcon;
},{"./mixins/style-propable":36,"react/addons":"react/addons"}],58:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var DropDownArrow = React.createClass({
        displayName: 'DropDownArrow',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('polygon', { points: '7,9.5 12,14.5 17,9.5 ' })
            );
        }

    });

    module.exports = DropDownArrow;
},{"../svg-icon":57,"react":"react"}],59:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var NavigationChevronLeftDouble = React.createClass({
        displayName: 'NavigationChevronLeftDouble',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M11.41 7.41 L10 6 l-6 6 6 6 1.41-1.41 L6.83 12z' }),
                React.createElement('path', { d: 'M18.41 7.41 L17 6 l-6 6 6 6 1.41-1.41 L13.83 12z' })
            );
        }

    });

    module.exports = NavigationChevronLeftDouble;
},{"../svg-icon":57,"react":"react"}],60:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var NavigationChevronLeft = React.createClass({
        displayName: 'NavigationChevronLeft',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z' })
            );
        }

    });

    module.exports = NavigationChevronLeft;
},{"../svg-icon":57,"react":"react"}],61:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var NavigationChevronRightDouble = React.createClass({
        displayName: 'NavigationChevronRightDouble',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M6 6 L4.59  7.41 9.17 12 l-4.58 4.59 L6 18 l6 -6z' }),
                React.createElement('path', { d: 'M13 6 L11.59 7.41 16.17 12 l-4.58 4.59 L13 18 l6 -6z' })
            );
        }

    });

    module.exports = NavigationChevronRightDouble;
},{"../svg-icon":57,"react":"react"}],62:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var NavigationChevronLeft = React.createClass({
        displayName: 'NavigationChevronLeft',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z' })
            );
        }

    });

    module.exports = NavigationChevronLeft;
},{"../svg-icon":57,"react":"react"}],63:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var NavigationMenu = React.createClass({
        displayName: 'NavigationMenu',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z' })
            );
        }

    });

    module.exports = NavigationMenu;
},{"../svg-icon":57,"react":"react"}],64:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var ToggleCheckBoxChecked = React.createClass({
        displayName: 'ToggleCheckBoxChecked',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M19,3H5C3.9,3,3,3.9,3,5v14c0,1.1,0.9,2,2,2h14c1.1,0,2-0.9,2-2V5C21,3.9,20.1,3,19,3z M10,17l-5-5l1.4-1.4 l3.6,3.6l7.6-7.6L19,8L10,17z' })
            );
        }

    });

    module.exports = ToggleCheckBoxChecked;
},{"../svg-icon":57,"react":"react"}],65:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var ToggleCheckBoxOutlineBlank = React.createClass({
        displayName: 'ToggleCheckBoxOutlineBlank',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M19,5v14H5V5H19 M19,3H5C3.9,3,3,3.9,3,5v14c0,1.1,0.9,2,2,2h14c1.1,0,2-0.9,2-2V5C21,3.9,20.1,3,19,3z' })
            );
        }

    });

    module.exports = ToggleCheckBoxOutlineBlank;
},{"../svg-icon":57,"react":"react"}],66:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var RadioButtonOff = React.createClass({
        displayName: 'RadioButtonOff',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8z' })
            );
        }

    });

    module.exports = RadioButtonOff;
},{"../svg-icon":57,"react":"react"}],67:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var SvgIcon = require('../svg-icon');

    var RadioButtonOn = React.createClass({
        displayName: 'RadioButtonOn',

        render: function render() {
            return React.createElement(
                SvgIcon,
                this.props,
                React.createElement('path', { d: 'M12 7c-2.76 0-5 2.24-5 5s2.24 5 5 5 5-2.24 5-5-2.24-5-5-5zm0-5C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8z' })
            );
        }

    });

    module.exports = RadioButtonOn;
},{"../svg-icon":57,"react":"react"}],68:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable.js');
    var Colors = require('../styles/colors.js');
    var Tab = React.createClass({
        displayName: 'Tab',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            handleTouchTap: React.PropTypes.func,
            selected: React.PropTypes.bool,
            width: React.PropTypes.string
        },

        handleTouchTap: function handleTouchTap() {
            this.props.handleTouchTap(this.props.tabIndex, this);
        },

        render: function render() {
            var styles = this.mergeAndPrefix({
                'display': 'table-cell',
                'cursor': 'pointer',
                'textAlign': 'center',
                'verticalAlign': 'middle',
                'height': '48px',
                'color': Colors.white,
                'opacity': '.6',
                'fontSize': '14px',
                'fontWeight': '500',
                'whiteSpace': 'initial',
                'fontFamily': this.context.muiTheme.contentFontFamily,
                'boxSizing': 'border-box',
                'width': this.props.width
            }, this.props.style);

            if (this.props.selected) styles.opacity = '1';

            return React.createElement(
                'div',
                { style: styles, onTouchTap: this.handleTouchTap, routeName: this.props.route },
                this.props.label
            );
        }

    });

    module.exports = Tab;
},{"../mixins/style-propable.js":36,"../styles/colors.js":50,"react":"react"}],69:[function(require,module,exports){
    'use strict';

    var React = require('react');

    var TabTemplate = React.createClass({
        displayName: 'TabTemplate',

        render: function render() {

            var styles = {
                'height': '0px',
                'overflow': 'hidden',
                'width': '100%',
                'position': 'relative',
                'textAlign': 'initial'
            };

            if (this.props.selected) {
                delete styles.height;
                delete styles.overflow;
            }

            return React.createElement(
                'div',
                { style: styles },
                this.props.children
            );
        } });

    module.exports = TabTemplate;
},{"react":"react"}],70:[function(require,module,exports){
    'use strict';

    var React = require('react/addons');
    var TabTemplate = require('./tabTemplate');
    var InkBar = require('../ink-bar');
    var StylePropable = require('../mixins/style-propable.js');
    var Events = require('../utils/events');

    var Tabs = React.createClass({
        displayName: 'Tabs',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            initialSelectedIndex: React.PropTypes.number,
            onActive: React.PropTypes.func,
            tabWidth: React.PropTypes.number
        },

        getInitialState: function getInitialState() {
            var selectedIndex = 0;
            if (this.props.initialSelectedIndex && this.props.initialSelectedIndex < this.props.children.length) {
                selectedIndex = this.props.initialSelectedIndex;
            }
            return {
                selectedIndex: selectedIndex
            };
        },

        getEvenWidth: function getEvenWidth() {
            return parseInt(window.getComputedStyle(React.findDOMNode(this)).getPropertyValue('width'), 10);
        },

        componentDidMount: function componentDidMount() {
            this._updateTabWidth();
            Events.on(window, 'resize', this._updateTabWidth);
        },

        componentWillUnmount: function componentWillUnmount() {
            Events.off(window, 'resize', this._updateTabWidth);
        },

        componentWillReceiveProps: function componentWillReceiveProps(newProps) {
            if (newProps.hasOwnProperty('style')) this._updateTabWidth();
        },

        handleTouchTap: function handleTouchTap(tabIndex, tab) {
            if (this.props.onChange && this.state.selectedIndex !== tabIndex) {
                this.props.onChange(tabIndex, tab);
            }

            this.setState({ selectedIndex: tabIndex });
            //default CB is _onActive. Can be updated in tab.jsx
            if (tab.props.onActive) tab.props.onActive(tab);
        },

        getStyles: function getStyles() {
            var themeVariables = this.context.muiTheme.component.tabs;

            return {
                tabItemContainer: {
                    margin: '0',
                    padding: '0',
                    width: '100%',
                    height: '48px',
                    backgroundColor: themeVariables.backgroundColor,
                    whiteSpace: 'nowrap',
                    display: 'table'
                }
            };
        },

        render: function render() {
            var styles = this.getStyles();

            var tabContent = [];
            var width = this.state.fixedWidth ? 100 / this.props.children.length + '%' : this.props.tabWidth + 'px';

            var left = 'calc(' + width + '*' + this.state.selectedIndex + ')';

            var tabs = React.Children.map(this.props.children, function (tab, index) {
                if (tab.type.displayName === 'Tab') {

                    if (tab.props.children) {
                        tabContent.push(React.createElement(TabTemplate, {
                            key: index,
                            selected: this.state.selectedIndex === index
                        }, tab.props.children));
                    } else {
                        tabContent.push(undefined);
                    }

                    return React.addons.cloneWithProps(tab, {
                        key: index,
                        selected: this.state.selectedIndex === index,
                        tabIndex: index,
                        width: width,
                        handleTouchTap: this.handleTouchTap
                    });
                } else {
                    var type = tab.type.displayName || tab.type;
                    throw 'Tabs only accepts Tab Components as children. Found ' + type + ' as child number ' + (index + 1) + ' of Tabs';
                }
            }, this);
            return React.createElement(
                'div',
                { style: this.mergeAndPrefix(this.props.style) },
                React.createElement(
                    'div',
                    { style: this.mergeAndPrefix(styles.tabItemContainer, this.props.tabItemContainerStyle) },
                    tabs
                ),
                React.createElement(InkBar, { left: left, width: width }),
                React.createElement(
                    'div',
                    null,
                    tabContent
                )
            );
        },

        _tabWidthPropIsValid: function _tabWidthPropIsValid() {
            return this.props.tabWidth && this.props.tabWidth * this.props.children.length <= this.getEvenWidth();
        },

        // Validates that the tabWidth can fit all tabs on the tab bar. If not, the
        // tabWidth is recalculated and fixed.
        _updateTabWidth: function _updateTabWidth() {
            if (this._tabWidthPropIsValid()) {
                this.setState({
                    fixedWidth: false
                });
            } else {
                this.setState({
                    fixedWidth: true
                });
            }
        }

    });

    module.exports = Tabs;
},{"../ink-bar":27,"../mixins/style-propable.js":36,"../utils/events":95,"./tabTemplate":69,"react/addons":"react/addons"}],71:[function(require,module,exports){
    (function (process){
        'use strict';

        var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

        function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

        var React = require('react');
        var ColorManipulator = require('./utils/color-manipulator');
        var Colors = require('./styles/colors');
        var StylePropable = require('./mixins/style-propable');
        var Transitions = require('./styles/transitions');
        var UniqueId = require('./utils/unique-id');
        var EnhancedTextarea = require('./enhanced-textarea');

        var TextField = React.createClass({
            displayName: 'TextField',

            mixins: [StylePropable],

            contextTypes: {
                muiTheme: React.PropTypes.object
            },

            propTypes: {
                errorText: React.PropTypes.string,
                floatingLabelText: React.PropTypes.string,
                hintText: React.PropTypes.string,
                id: React.PropTypes.string,
                multiLine: React.PropTypes.bool,
                onBlur: React.PropTypes.func,
                onChange: React.PropTypes.func,
                onFocus: React.PropTypes.func,
                onKeyDown: React.PropTypes.func,
                onEnterKeyDown: React.PropTypes.func,
                type: React.PropTypes.string,
                rows: React.PropTypes.number
            },

            getDefaultProps: function getDefaultProps() {
                return {
                    type: 'text',
                    rows: 1
                };
            },

            getInitialState: function getInitialState() {
                return {
                    errorText: this.props.errorText,
                    hasValue: this.props.value || this.props.defaultValue || this.props.valueLink && this.props.valueLink.value
                };
            },

            componentDidMount: function componentDidMount() {
                this._uniqueId = UniqueId.generate();
            },

            componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
                var hasErrorProp = nextProps.hasOwnProperty('errorText');
                var hasValueLinkProp = nextProps.hasOwnProperty('valueLink');
                var hasValueProp = nextProps.hasOwnProperty('value');
                var hasNewDefaultValue = nextProps.defaultValue !== this.props.defaultValue;
                var newState = {};

                if (hasValueProp) {
                    newState.hasValue = nextProps.value;
                } else if (hasValueLinkProp) {
                    newState.hasValue = nextProps.valueLink.value;
                } else if (hasNewDefaultValue) {
                    newState.hasValue = nextProps.defaultValue;
                }

                if (hasErrorProp) newState.errorText = nextProps.errorText;
                if (newState) this.setState(newState);
            },

            errorColor: Colors.red500,

            getStyles: function getStyles() {
                var palette = this.context.muiTheme.palette;
                var disabledTextColor = palette.disabledColor;

                var styles = {
                    root: {
                        fontSize: '16px',
                        lineHeight: '24px',
                        width: 64 * 4,
                        height: (this.props.rows - 1) * 24 + (this.props.floatingLabelText ? 72 : 48),
                        display: 'inline-block',
                        position: 'relative',
                        fontFamily: this.context.muiTheme.contentFontFamily,
                        transition: Transitions.easeOut('200ms', 'height')
                    },
                    error: {
                        position: 'absolute',
                        bottom: -10,
                        fontSize: '12px',
                        lineHeight: '12px',
                        color: this.errorColor,
                        transition: Transitions.easeOut() },
                    hint: {
                        position: 'absolute',
                        lineHeight: '48px',
                        opacity: 1,
                        color: disabledTextColor,
                        transition: Transitions.easeOut()
                    },
                    input: {
                        WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                        position: 'relative',
                        width: '100%',
                        height: '100%',
                        border: 'none',
                        outline: 'none',
                        backgroundColor: 'transparent',
                        color: this.props.disabled ? disabledTextColor : palette.textColor,
                        font: 'inherit'
                    },
                    underline: {
                        border: 'none',
                        borderBottom: 'solid 1px ' + palette.borderColor,
                        position: 'absolute',
                        width: '100%',
                        bottom: 8,
                        margin: 0,
                        MozBoxSizing: 'content-box',
                        boxSizing: 'content-box',
                        height: 0
                    },
                    underlineAfter: {
                        position: 'absolute',
                        width: '100%',
                        overflow: 'hidden',
                        userSelect: 'none',
                        cursor: 'default',
                        bottom: 0,
                        color: disabledTextColor
                    }
                };

                styles.floatingLabel = this.mergeStyles(styles.hint, {
                    top: 24,
                    opacity: 1,
                    transform: 'scale(1) translate3d(0, 0, 0)',
                    transformOrigin: 'left top'
                });

                styles.textarea = this.mergeStyles(styles.input, {
                    marginTop: this.props.floatingLabelText ? 36 : 12,
                    marginBottom: this.props.floatingLabelText ? -36 : -12,
                    boxSizing: 'border-box',
                    font: 'inherit'
                });

                styles.focusUnderline = this.mergeStyles(styles.underline, {
                    borderBottom: 'solid 2px',
                    borderColor: palette.primary1Color,
                    transform: 'scaleX(0)',
                    transition: Transitions.easeOut() });

                if (this.state.isFocused) {
                    styles.floatingLabel.color = palette.primary1Color;
                    styles.floatingLabel.transform = 'perspective(1px) scale(0.75) translate3d(0, -18px, 0)';
                    styles.focusUnderline.transform = 'scaleX(1)';
                }

                if (this.state.hasValue) {
                    styles.floatingLabel.color = ColorManipulator.fade(palette.textColor, 0.5);
                    styles.floatingLabel.transform = 'perspective(1px) scale(0.75) translate3d(0, -18px, 0)';
                    styles.hint.opacity = 0;
                }

                if (this.props.floatingLabelText) {
                    styles.hint.top = 24;
                    styles.hint.opacity = 0;
                    styles.input.boxSizing = 'border-box';
                    if (this.state.isFocused && !this.state.hasValue) styles.hint.opacity = 1;
                }

                if (this.props.errorText && this.state.isFocused) styles.floatingLabel.color = this.errorColor;
                if (this.props.floatingLabelText && !this.props.multiLine) styles.input.paddingTop = 26;

                if (this.props.errorText) {
                    styles.focusUnderline.borderColor = this.errorColor;
                    styles.focusUnderline.transform = 'scaleX(1)';
                }

                return styles;
            },

            render: function render() {
                var _props = this.props;
                var className = _props.className;
                var errorText = _props.errorText;
                var floatingLabelText = _props.floatingLabelText;
                var hintText = _props.hintText;
                var id = _props.id;
                var multiLine = _props.multiLine;
                var onBlur = _props.onBlur;
                var onChange = _props.onChange;
                var onFocus = _props.onFocus;
                var type = _props.type;
                var rows = _props.rows;

                var other = _objectWithoutProperties(_props, ['className', 'errorText', 'floatingLabelText', 'hintText', 'id', 'multiLine', 'onBlur', 'onChange', 'onFocus', 'type', 'rows']);

                var styles = this.getStyles();

                var inputId = this.props.id || this._uniqueId;

                var errorTextElement = this.state.errorText ? React.createElement(
                    'div',
                    { style: this.mergeAndPrefix(styles.error) },
                    this.state.errorText
                ) : null;

                var hintTextElement = this.props.hintText ? React.createElement(
                    'div',
                    { style: this.mergeAndPrefix(styles.hint) },
                    this.props.hintText
                ) : null;

                var floatingLabelTextElement = this.props.floatingLabelText ? React.createElement(
                    'label',
                    {
                        style: this.mergeAndPrefix(styles.floatingLabel),
                        htmlFor: inputId },
                    this.props.floatingLabelText
                ) : null;

                var inputProps;
                var inputElement;

                inputProps = {
                    id: inputId,
                    ref: this._getRef(),
                    style: this.mergeAndPrefix(styles.input),
                    onBlur: this._handleInputBlur,
                    onFocus: this._handleInputFocus,
                    onKeyDown: this._handleInputKeyDown
                };

                if (!this.props.hasOwnProperty('valueLink')) {
                    inputProps.onChange = this._handleInputChange;
                }

                inputElement = this.props.multiLine ? React.createElement(EnhancedTextarea, _extends({}, other, inputProps, {
                    rows: this.props.rows,
                    onHeightChange: this._handleTextAreaHeightChange,
                    textareaStyle: this.mergeAndPrefix(styles.textarea) })) : React.createElement('input', _extends({}, other, inputProps, {
                    type: this.props.type }));

                var underlineElement = this.props.disabled ? React.createElement(
                    'div',
                    { style: this.mergeAndPrefix(styles.underlineAfter) },
                    '....................................................................................'
                ) : React.createElement('hr', { style: this.mergeAndPrefix(styles.underline) });
                var focusUnderlineElement = React.createElement('hr', { style: this.mergeAndPrefix(styles.focusUnderline) });

                return React.createElement(
                    'div',
                    { className: this.props.className, style: this.mergeAndPrefix(styles.root, this.props.style) },
                    floatingLabelTextElement,
                    hintTextElement,
                    inputElement,
                    underlineElement,
                    focusUnderlineElement,
                    errorTextElement
                );
            },

            blur: function blur() {
                if (this.isMounted()) this._getInputNode().blur();
            },

            clearValue: function clearValue() {
                this.setValue('');
            },

            focus: function focus() {
                if (this.isMounted()) this._getInputNode().focus();
            },

            getValue: function getValue() {
                return this.isMounted() ? this._getInputNode().value : undefined;
            },

            setErrorText: function setErrorText(newErrorText) {
                if (process.env.NODE_ENV !== 'production' && this.props.hasOwnProperty('errorText')) {
                    console.error('Cannot call TextField.setErrorText when errorText is defined as a property.');
                } else if (this.isMounted()) {
                    this.setState({ errorText: newErrorText });
                }
            },

            setValue: function setValue(newValue) {
                if (process.env.NODE_ENV !== 'production' && this._isControlled()) {
                    console.error('Cannot call TextField.setValue when value or valueLink is defined as a property.');
                } else if (this.isMounted()) {
                    this._getInputNode().value = newValue;
                    this.setState({ hasValue: newValue });
                }
            },

            _getRef: function _getRef() {
                return this.props.ref ? this.props.ref : 'input';
            },

            _getInputNode: function _getInputNode() {
                return this.props.multiLine ? this.refs[this._getRef()].getInputNode() : React.findDOMNode(this.refs[this._getRef()]);
            },

            _handleInputBlur: function _handleInputBlur(e) {
                this.setState({ isFocused: false });
                if (this.props.onBlur) this.props.onBlur(e);
            },

            _handleInputChange: function _handleInputChange(e) {
                this.setState({ hasValue: e.target.value });
                if (this.props.onChange) this.props.onChange(e);
            },

            _handleInputFocus: function _handleInputFocus(e) {
                this.setState({ isFocused: true });
                if (this.props.onFocus) this.props.onFocus(e);
            },

            _handleInputKeyDown: function _handleInputKeyDown(e) {
                if (e.keyCode === 13 && this.props.onEnterKeyDown) this.props.onEnterKeyDown(e);
                if (this.props.onKeyDown) this.props.onKeyDown(e);
            },

            _handleTextAreaHeightChange: function _handleTextAreaHeightChange(e, height) {
                var newHeight = height + 24;
                if (this.props.floatingLabelText) newHeight += 24;
                React.findDOMNode(this).style.height = newHeight + 'px';
            },

            _isControlled: function _isControlled() {
                return this.props.hasOwnProperty('value') || this.props.hasOwnProperty('valueLink');
            }

        });

        module.exports = TextField;
    }).call(this,require('_process'))
},{"./enhanced-textarea":22,"./mixins/style-propable":36,"./styles/colors":50,"./styles/transitions":55,"./utils/color-manipulator":91,"./utils/unique-id":100,"_process":103,"react":"react"}],72:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    var React = require('react');
    var ThemeManager = require('./styles/theme-manager');

    var Theme = React.createClass({
        displayName: 'Theme',

        propTypes: {
            theme: React.PropTypes.object
        },

        childContextTypes: {
            muiTheme: React.PropTypes.object.isRequired,
            muiThemeManager: React.PropTypes.object.isRequired
        },

        getChildContext: function getChildContext() {
            return {
                muiTheme: this.themeManager.getCurrentTheme(),
                muiThemeManager: this.themeManager
            };
        },

        componentWillMount: function componentWillMount() {
            this.themeManager = new ThemeManager();

            if (this.props.theme) {
                this.themeManager.setTheme(this.props.theme);
            }
        },

        render: function render() {
            return this.props.children({
                muiTheme: this.themeManager.getCurrentTheme(),
                muiThemeManager: this.themeManager
            });
        }
    });

    function getDisplayName(Component) {
        return Component.displayName || Component.name || 'Component';
    }

    function theme(customTheme) {
        return function (Component) {
            return React.createClass({

                displayName: 'Theme(' + getDisplayName(Component) + ')',

                render: function render() {
                    return React.createElement(
                        Theme,
                        { theme: customTheme },
                        (function (props) {
                            return React.createElement(Component, _extends({}, this.props, props));
                        }).bind(this)
                    );
                }
            });
        };
    }

    module.exports = Theme;
    module.exports.theme = theme;
},{"./styles/theme-manager":52,"react":"react"}],73:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var EnhancedButton = require('../enhanced-button');
    var Transitions = require('../styles/transitions');

    var ClockButton = React.createClass({
        displayName: 'ClockButton',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            position: React.PropTypes.oneOf(['left', 'right'])
        },

        getDefaultProps: function getDefaultProps() {
            return {
                position: 'left'
            };
        },
        _handleTouchTap: function _handleTouchTap() {

            this.setState({
                selected: true
            });
            this.props.onTouchTap();
        },
        getTheme: function getTheme() {
            return this.context.muiTheme.component.timePicker;
        },
        render: function render() {
            var _props = this.props;
            var className = _props.className;

            var other = _objectWithoutProperties(_props, ['className']);

            var styles = {
                root: {
                    position: 'absolute',
                    bottom: '65px',
                    pointerEvents: 'auto',
                    height: '50px',
                    width: '50px',
                    borderRadius: '100%'
                },

                label: {
                    position: 'absolute',
                    top: '17px',
                    left: '14px'
                },

                select: {
                    position: 'absolute',
                    height: 50,
                    width: 50,
                    top: '0px',
                    left: '0px',
                    opacity: 0,
                    borderRadius: '50%',
                    transform: 'scale(0)',
                    transition: Transitions.easeOut(),
                    backgroundColor: this.getTheme().accentColor } };

            if (this.props.selected) {
                styles.label.color = this.getTheme().selectTextColor;
                styles.select.opacity = 1;
                styles.select.transform = 'scale(1)';
            }

            if (this.props.position == 'right') {
                styles.root.right = '5px';
            } else {
                styles.root.left = '5px';
            }

            return React.createElement(
                EnhancedButton,
                _extends({}, other, {
                    style: this.mergeAndPrefix(styles.root),
                    disableFocusRipple: true,
                    disableTouchRipple: true,
                    onTouchTap: this._handleTouchTap }),
                React.createElement('span', { style: this.mergeAndPrefix(styles.select) }),
                React.createElement(
                    'span',
                    { style: this.mergeAndPrefix(styles.label) },
                    this.props.children
                )
            );
        }
    });

    module.exports = ClockButton;
},{"../enhanced-button":20,"../mixins/style-propable":36,"../styles/transitions":55,"react":"react"}],74:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var ClockNumber = require('./clock-number');
    var ClockPointer = require('./clock-pointer');

    function rad2deg(rad) {
        return rad * 57.29577951308232;
    }

    var ClockHours = React.createClass({
        displayName: 'ClockHours',

        mixins: [StylePropable],

        propTypes: {
            initialHours: React.PropTypes.number,
            onChange: React.PropTypes.func,
            format: React.PropTypes.oneOf(['ampm', '24hr'])
        },

        center: { x: 0, y: 0 },
        basePoint: { x: 0, y: 0 },
        isMousePressed: function isMousePressed(e) {

            if (typeof e.buttons == 'undefined') {
                return e.nativeEvent.which;
            }

            return e.buttons;
        },
        getDefaultProps: function getDefaultProps() {
            return {
                initialHours: new Date().getHours(),
                onChange: function onChange() {},
                format: 'ampm'
            };
        },

        componentDidMount: function componentDidMount() {
            var clockElement = React.findDOMNode(this.refs.mask);

            this.center = {
                x: clockElement.offsetWidth / 2,
                y: clockElement.offsetHeight / 2 };

            this.basePoint = {
                x: this.center.x,
                y: 0
            };
        },
        handleUp: function handleUp(e) {
            e.preventDefault();
            this.setClock(e, true);
        },
        handleMove: function handleMove(e) {
            e.preventDefault();
            if (this.isMousePressed(e) != 1) return;
            this.setClock(e, false);
        },
        handleTouch: function handleTouch(e) {
            e.preventDefault();
            this.setClock(e, false);
        },
        setClock: function setClock(e, finish) {

            var pos = {
                x: e.nativeEvent.offsetX,
                y: e.nativeEvent.offsetY
            };

            var hours = this.getHours(pos.x, pos.y);

            this.props.onChange(hours, finish);
        },
        getHours: function getHours(x, y) {

            var step = 30;
            x = x - this.center.x;
            y = y - this.center.y;
            var cx = this.basePoint.x - this.center.x;
            var cy = this.basePoint.y - this.center.y;

            var atan = Math.atan2(cx, cy) - Math.atan2(x, y);

            var deg = rad2deg(atan);
            deg = Math.round(deg / step) * step;
            deg %= 360;

            var value = Math.floor(deg / step) || 0;

            var delta = Math.pow(x, 2) + Math.pow(y, 2);
            var distance = Math.sqrt(delta);

            value = value || 12;
            if (this.props.format == '24hr') {
                if (distance < 90) {
                    value += 12;
                    value %= 24;
                }
            } else {
                value %= 12;
            }

            return value;
        },
        _getSelected: function _getSelected() {

            var hour = this.props.initialHours;

            if (this.props.format == 'ampm') {
                hour %= 12;
                hour = hour || 12;
            }

            return hour;
        },
        _getHourNumbers: function _getHourNumbers() {
            var style = {
                pointerEvents: 'none'
            };

            var hourSize = this.props.format == 'ampm' ? 12 : 24;

            var hours = [];

            for (var i = 1; i <= hourSize; i++) {
                hours.push(i % 24);
            }

            return hours.map((function (hour) {

                var isSelected = this._getSelected() == hour;
                return React.createElement(ClockNumber, { style: style, isSelected: isSelected, type: 'hour', value: hour });
            }).bind(this));
        },

        render: function render() {

            var styles = {
                root: {
                    height: '100%',
                    width: '100%',
                    borderRadius: '100%',
                    position: 'relative',
                    pointerEvents: 'none',
                    boxSizing: 'border-box' },

                hitMask: {
                    height: '100%',
                    width: '100%',
                    pointerEvents: 'auto' } };

            var hours = this._getSelected();
            var numbers = this._getHourNumbers();

            return React.createElement(
                'div',
                { ref: 'clock', style: this.mergeAndPrefix(styles.root) },
                React.createElement(ClockPointer, { hasSelected: true, value: hours, type: 'hour' }),
                numbers,
                React.createElement('div', { ref: 'mask', style: this.mergeAndPrefix(styles.hitMask), onTouchMove: this.handleTouch, onTouchEnd: this.handleUp, onMouseUp: this.handleUp, onMouseMove: this.handleMove })
            );
        }
    });

    module.exports = ClockHours;
},{"../mixins/style-propable":36,"./clock-number":76,"./clock-pointer":77,"react":"react"}],75:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var ClockNumber = require('./clock-number');
    var ClockPointer = require('./clock-pointer');

    function rad2deg(rad) {
        return rad * 57.29577951308232;
    }

    var ClockMinutes = React.createClass({
        displayName: 'ClockMinutes',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            initialMinutes: React.PropTypes.number,
            onChange: React.PropTypes.func
        },

        center: { x: 0, y: 0 },
        basePoint: { x: 0, y: 0 },
        isMousePressed: function isMousePressed(e) {

            if (typeof e.buttons == 'undefined') {
                return e.nativeEvent.which;
            }
            return e.buttons;
        },
        getDefaultProps: function getDefaultProps() {
            return {
                initialMinutes: new Date().getMinutes(),
                onChange: function onChange() {}
            };
        },

        componentDidMount: function componentDidMount() {
            var clockElement = React.findDOMNode(this.refs.mask);

            this.center = {
                x: clockElement.offsetWidth / 2,
                y: clockElement.offsetHeight / 2 };

            this.basePoint = {
                x: this.center.x,
                y: 0
            };
        },
        handleUp: function handleUp(e) {
            e.preventDefault();
            this.setClock(e, true);
        },
        handleMove: function handleMove(e) {
            e.preventDefault();
            if (this.isMousePressed(e) != 1) return;
            this.setClock(e, false);
        },
        handleTouch: function handleTouch(e) {
            e.preventDefault();
            this.setClock(e, false);
        },
        setClock: function setClock(e, finish) {

            e.preventDefault();
            if (this.isMousePressed(e) != 1) return;

            var pos = {
                x: e.nativeEvent.offsetX,
                y: e.nativeEvent.offsetY
            };

            var minutes = this.getMinutes(pos.x, pos.y);

            this.props.onChange(minutes, finish);
        },
        getMinutes: function getMinutes(x, y) {

            var step = 6;
            x = x - this.center.x;
            y = y - this.center.y;
            var cx = this.basePoint.x - this.center.x;
            var cy = this.basePoint.y - this.center.y;

            var atan = Math.atan2(cx, cy) - Math.atan2(x, y);

            var deg = rad2deg(atan);
            deg = Math.round(deg / step) * step;
            deg %= 360;

            var value = Math.floor(deg / step) || 0;

            return value;
        },
        _getMinuteNumbers: function _getMinuteNumbers() {

            var minutes = [];
            for (var i = 0; i < 12; i++) {
                minutes.push(i * 5);
            }
            var selectedMinutes = this.props.initialMinutes;

            var hasSelected = false;

            var numbers = minutes.map((function (minute) {
                var isSelected = selectedMinutes == minute;
                if (isSelected) hasSelected = true;
                return React.createElement(ClockNumber, { isSelected: isSelected, type: 'minute', value: minute });
            }).bind(this));

            return {
                numbers: numbers,
                hasSelected: hasSelected,
                selected: selectedMinutes
            };
        },
        render: function render() {

            var styles = {
                root: {
                    height: '100%',
                    width: '100%',
                    borderRadius: '100%',
                    position: 'relative',
                    pointerEvents: 'none',
                    boxSizing: 'border-box' },

                hitMask: {
                    height: '100%',
                    width: '100%',
                    pointerEvents: 'auto' } };

            var minutes = this._getMinuteNumbers();

            return React.createElement(
                'div',
                { ref: 'clock', style: this.mergeAndPrefix(styles.root) },
                React.createElement(ClockPointer, { value: minutes.selected, type: 'minute' }),
                minutes.numbers,
                React.createElement('div', { ref: 'mask', style: this.mergeAndPrefix(styles.hitMask), hasSelected: minutes.hasSelected, onTouchMove: this.handleTouch, onTouchEnd: this.handleUp, onMouseUp: this.handleUp, onMouseMove: this.handleMove })
            );
        }
    });

    module.exports = ClockMinutes;
},{"../mixins/style-propable":36,"./clock-number":76,"./clock-pointer":77,"react":"react"}],76:[function(require,module,exports){
    'use strict';

    function _slicedToArray(arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i['return']) _i['return'](); } finally { if (_d) throw _e; } } return _arr; } else { throw new TypeError('Invalid attempt to destructure non-iterable instance'); } }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var ClockNumber = React.createClass({
        displayName: 'ClockNumber',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            value: React.PropTypes.number,
            type: React.PropTypes.oneOf(['hour', 'minute']),
            onSelected: React.PropTypes.func,
            isSelected: React.PropTypes.bool
        },
        getDefaultProps: function getDefaultProps() {
            return {
                value: 0,
                type: 'minute',
                isSelected: false
            };
        },
        getTheme: function getTheme() {
            return this.context.muiTheme.component.timePicker;
        },
        render: function render() {

            var pos = this.props.value;

            var inner = false;

            if (this.props.type == 'hour') {
                inner = pos < 1 || pos > 12;
                pos %= 12;
            } else {
                pos = pos / 5;
            }

            var positions = [[0, 5], [54.5, 16.6], [94.4, 59.5], [109, 114], [94.4, 168.5], [54.5, 208.4], [0, 223], [-54.5, 208.4], [-94.4, 168.5], [-109, 114], [-94.4, 59.5], [-54.5, 19.6]];

            var innerPositions = [[0, 40], [36.9, 49.9], [64, 77], [74, 114], [64, 151], [37, 178], [0, 188], [-37, 178], [-64, 151], [-74, 114], [-64, 77], [-37, 50]];

            var styles = {
                root: {
                    display: 'inline-block',
                    position: 'absolute',
                    width: '32px',
                    height: '32px',
                    borderRadius: '100%',
                    left: 'calc(50% - 16px)',
                    top: '10px',
                    textAlign: 'center',
                    paddingTop: '5px',
                    userSelect: 'none', /* Chrome all / Safari all */
                    fontSize: '1.1em',
                    pointerEvents: 'none',
                    boxSizing: 'border-box' }

            };

            if (this.props.isSelected) {
                styles.root.backgroundColor = this.getTheme().accentColor;
                styles.root.color = this.getTheme().selectTextColor;
            }

            var transformPos = positions[pos];

            if (inner) {
                styles.root.width = '28px';
                styles.root.height = '28px';
                styles.root.left = 'calc(50% - 14px)';
                transformPos = innerPositions[pos];
            }

            var _transformPos = _slicedToArray(transformPos, 2);

            var x = _transformPos[0];
            var y = _transformPos[1];

            styles.root.transform = 'translate(' + x + 'px, ' + y + 'px)';

            return React.createElement(
                'span',
                { style: styles.root },
                this.props.value
            );
        }
    });

    module.exports = ClockNumber;
},{"../mixins/style-propable":36,"react":"react"}],77:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var ClockPointer = React.createClass({
        displayName: 'ClockPointer',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            value: React.PropTypes.number,
            type: React.PropTypes.oneOf(['hour', 'minute'])
        },

        getInitialState: function getInitialState() {
            return {
                inner: this.isInner(this.props.value)
            };
        },
        getDefaultProps: function getDefaultProps() {
            return {
                value: null,
                type: 'minute',
                hasSelected: false
            };
        },
        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

            this.setState({
                inner: this.isInner(nextProps.value)
            });
        },
        isInner: function isInner(value) {
            if (this.props.type != 'hour') {
                return false;
            }
            return value < 1 || value > 12;
        },
        getAngle: function getAngle() {

            if (this.props.type == 'hour') {
                return this.calcAngle(this.props.value, 12);
            }

            return this.calcAngle(this.props.value, 60);
        },
        calcAngle: function calcAngle(value, base) {
            value %= base;
            var angle = 360 / base * value;
            return angle;
        },
        getTheme: function getTheme() {
            return this.context.muiTheme.component.timePicker;
        },
        render: function render() {

            if (this.props.value == null) {
                return React.createElement('span', null);
            }

            var angle = this.getAngle();

            var styles = {
                root: {
                    height: '30%',
                    background: this.getTheme().accentColor,
                    width: '2px',
                    left: 'calc(50% - 1px)',
                    position: 'absolute',
                    bottom: '50%',
                    transformOrigin: 'bottom',
                    pointerEvents: 'none',
                    transform: 'rotateZ(' + angle + 'deg)'
                },
                mark: {
                    background: this.getTheme().selectTextColor,
                    border: '4px solid ' + this.getTheme().accentColor,
                    width: '7px',
                    height: '7px',
                    position: 'absolute',
                    top: '-5px',
                    left: '-6px',
                    borderRadius: '100%' }
            };

            if (!this.state.inner) {
                styles.root.height = '40%';
            }

            if (this.props.hasSelected) {
                styles.mark.display = 'none';
            }

            return React.createElement(
                'div',
                { style: styles.root },
                React.createElement('div', { style: styles.mark })
            );
        }
    });

    module.exports = ClockPointer;
},{"../mixins/style-propable":36,"react":"react"}],78:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var TimeDisplay = require('./time-display');
    var ClockButton = require('./clock-button');
    var ClockHours = require('./clock-hours');
    var ClockMinutes = require('./clock-minutes');

    var Clock = React.createClass({
        displayName: 'Clock',

        mixins: [StylePropable],

        propTypes: {
            initialTime: React.PropTypes.object,
            mode: React.PropTypes.oneOf(['hour', 'minute']),
            format: React.PropTypes.oneOf(['ampm', '24hr']),
            isActive: React.PropTypes.bool
        },

        init: function init() {
            this.setState({
                mode: 'hour'
            });
        },

        getDefaultProps: function getDefaultProps() {
            return {
                initialTime: new Date()
            };
        },

        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

            this.setState({
                selectedTime: nextProps.initialTime
            });
        },

        getInitialState: function getInitialState() {

            return {
                selectedTime: this.props.initialTime,
                mode: 'hour'
            };
        },

        _setMode: function _setMode(mode) {
            setTimeout((function () {
                this.setState({
                    mode: mode
                });
            }).bind(this), 100);
        },

        _setAffix: function _setAffix(affix) {

            if (affix == this._getAffix()) return;

            var hours = this.state.selectedTime.getHours();

            if (affix == 'am') {
                this.handleChangeHours(hours - 12);
                return;
            }

            this.handleChangeHours(hours + 12);
        },

        _getAffix: function _getAffix() {

            if (this.props.format != 'ampm') return '';

            var hours = this.state.selectedTime.getHours();
            if (hours < 12) {
                return 'am';
            }

            return 'pm';
        },

        _getButtons: function _getButtons() {
            var buttons = [];
            var isAM = this._getIsAM();

            if (this.props.format == 'ampm') {
                buttons = [React.createElement(
                    ClockButton,
                    { position: 'left', onTouchTap: this._setAffix.bind(this, 'am'), selected: isAM },
                    'AM'
                ), React.createElement(
                    ClockButton,
                    { position: 'right', onTouchTap: this._setAffix.bind(this, 'pm'), selected: !isAM },
                    'PM'
                )];
            }
            return buttons;
        },

        _getIsAM: function _getIsAM() {

            return this._getAffix() == 'am';
        },

        render: function render() {

            var clock = null;
            var buttons = this._getButtons();

            var styles = {
                root: {},

                container: {
                    height: '280px',
                    padding: '10px' }
            };

            if (this.state.mode == 'hour') {
                clock = React.createElement(ClockHours, { key: 'hours',
                    format: this.props.format,
                    onChange: this.handleChangeHours,
                    initialHours: this.state.selectedTime.getHours() });
            } else {
                clock = React.createElement(ClockMinutes, { key: 'minutes',
                    onChange: this.handleChangeMinutes,
                    initialMinutes: this.state.selectedTime.getMinutes() });
            }

            return React.createElement(
                'div',
                { style: styles.root },
                React.createElement(TimeDisplay, {
                    selectedTime: this.state.selectedTime,
                    mode: this.state.mode,
                    format: this.props.format,
                    affix: this._getAffix(),
                    onSelectHour: this._setMode.bind(this, 'hour'),
                    onSelectMin: this._setMode.bind(this, 'minute')
                }),
                React.createElement(
                    'div',
                    {
                        style: styles.container },
                    clock
                ),
                buttons
            );
        },
        handleChangeHours: function handleChangeHours(hours, finished) {
            var time = new Date(this.state.selectedTime);

            time.setHours(hours);
            this.setState({
                selectedTime: time
            });

            if (finished) {
                setTimeout((function () {
                    this.setState({
                        mode: 'minute'
                    });
                }).bind(this), 100);
            }
        },
        handleChangeMinutes: function handleChangeMinutes(minutes) {
            var time = new Date(this.state.selectedTime);
            time.setMinutes(minutes);
            this.setState({
                selectedTime: time
            });
        },
        getSelectedTime: function getSelectedTime() {
            return this.state.selectedTime;
        }
    });

    module.exports = Clock;
},{"../mixins/style-propable":36,"./clock-button":73,"./clock-hours":74,"./clock-minutes":75,"./time-display":80,"react":"react"}],79:[function(require,module,exports){
    'use strict';

    module.exports = require('./time-picker');
},{"./time-picker":82}],80:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _slicedToArray(arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i['return']) _i['return'](); } finally { if (_d) throw _e; } } return _arr; } else { throw new TypeError('Invalid attempt to destructure non-iterable instance'); } }

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var TimeDisplay = React.createClass({
        displayName: 'TimeDisplay',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            selectedTime: React.PropTypes.object.isRequired,
            format: React.PropTypes.oneOf(['ampm', '24hr']),
            mode: React.PropTypes.oneOf(['hour', 'minute']),
            affix: React.PropTypes.oneOf(['', 'pm', 'am'])
        },

        getInitialState: function getInitialState() {
            return {
                transitionDirection: 'up'
            };
        },
        getDefaultProps: function getDefaultProps() {
            return {
                mode: 'hour',
                affix: ''
            };
        },
        componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
            var direction;

            if (nextProps.selectedTime !== this.props.selectedTime) {
                direction = nextProps.selectedTime > this.props.selectedTime ? 'up' : 'down';
                this.setState({
                    transitionDirection: direction
                });
            }
        },
        sanitizeTime: function sanitizeTime() {
            var hour = this.props.selectedTime.getHours();
            var min = this.props.selectedTime.getMinutes().toString();

            if (this.props.format == 'ampm') {

                hour %= 12;
                hour = hour || 12;
            }

            hour = hour.toString();
            if (hour.length < 2) hour = '0' + hour;
            if (min.length < 2) min = '0' + min;

            return [hour, min];
        },
        getTheme: function getTheme() {
            return this.context.muiTheme.component.timePicker;
        },
        render: function render() {
            var _props = this.props;
            var selectedTime = _props.selectedTime;
            var mode = _props.mode;

            var other = _objectWithoutProperties(_props, ['selectedTime', 'mode']);

            var styles = {
                root: {
                    textAlign: 'center',
                    position: 'relative',
                    width: '280px',
                    height: '100%' },

                time: {
                    margin: '6px 0',
                    lineHeight: '58px',
                    height: '58px',
                    fontSize: '58px' },

                box: {
                    padding: '16px 0',
                    backgroundColor: this.getTheme().color,
                    color: this.getTheme().textColor },

                hour: {},

                minute: {}
            };

            var _sanitizeTime = this.sanitizeTime();

            var _sanitizeTime2 = _slicedToArray(_sanitizeTime, 2);

            var hour = _sanitizeTime2[0];
            var min = _sanitizeTime2[1];

            styles[mode].color = this.getTheme().accentColor;

            return React.createElement(
                'div',
                _extends({}, other, { style: this.mergeAndPrefix(styles.root) }),
                React.createElement(
                    'div',
                    { style: this.mergeAndPrefix(styles.box) },
                    React.createElement(
                        'div',
                        { style: this.mergeAndPrefix(styles.time) },
                        React.createElement(
                            'span',
                            { style: this.mergeAndPrefix(styles.hour), onTouchTap: this.props.onSelectHour },
                            hour
                        ),
                        React.createElement(
                            'span',
                            null,
                            ':'
                        ),
                        React.createElement(
                            'span',
                            { style: this.mergeAndPrefix(styles.minute), onTouchTap: this.props.onSelectMin },
                            min
                        )
                    ),
                    React.createElement(
                        'span',
                        { key: 'affix' },
                        this.props.affix.toUpperCase()
                    )
                )
            );
        }

    });

    module.exports = TimeDisplay;
},{"../mixins/style-propable":36,"react":"react"}],81:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');
    var WindowListenable = require('../mixins/window-listenable');
    var KeyCode = require('../utils/key-code');
    var Clock = require('./clock');
    var DialogWindow = require('../dialog-window');
    var FlatButton = require('../flat-button');

    var TimePickerDialog = React.createClass({
        displayName: 'TimePickerDialog',

        mixins: [StylePropable, WindowListenable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            initialTime: React.PropTypes.object,
            onAccept: React.PropTypes.func,
            onShow: React.PropTypes.func,
            onDismiss: React.PropTypes.func },

        windowListeners: {
            'keyup': '_handleWindowKeyUp'
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.timePicker;
        },
        render: function render() {
            var _props = this.props;
            var initialTime = _props.initialTime;
            var onAccept = _props.onAccept;
            var format = _props.format;

            var other = _objectWithoutProperties(_props, ['initialTime', 'onAccept', 'format']);

            var styles = {
                root: {
                    fontSize: '14px',
                    color: this.getTheme().clockColor },
                dialogContent: {
                    width: '280px' }
            };

            var actions = [React.createElement(FlatButton, {
                key: 0,
                label: 'Cancel',
                secondary: true,
                onTouchTap: this._handleCancelTouchTap }), React.createElement(FlatButton, {
                key: 1,
                label: 'OK',
                secondary: true,
                onTouchTap: this._handleOKTouchTap })];

            return React.createElement(
                DialogWindow,
                _extends({}, other, {
                    ref: 'dialogWindow',
                    style: this.mergeAndPrefix(styles.root),
                    actions: actions,
                    contentStyle: styles.dialogContent,
                    onDismiss: this._handleDialogDismiss,
                    onShow: this._handleDialogShow,
                    repositionOnUpdate: false }),
                React.createElement(Clock, {
                    ref: 'clock',
                    format: format,
                    initialTime: initialTime })
            );
        },

        show: function show() {
            this.refs.dialogWindow.show();
            this.refs.clock.init();
        },

        dismiss: function dismiss() {
            this.refs.dialogWindow.dismiss();
        },

        _handleCancelTouchTap: function _handleCancelTouchTap() {
            this.dismiss();
        },

        _handleOKTouchTap: function _handleOKTouchTap() {
            this.dismiss();
            if (this.props.onAccept) {
                this.props.onAccept(this.refs.clock.getSelectedTime());
            }
        },

        _handleDialogShow: function _handleDialogShow() {

            if (this.props.onShow) {
                this.props.onShow();
            }
        },

        _handleDialogDismiss: function _handleDialogDismiss() {

            if (this.props.onDismiss) {
                this.props.onDismiss();
            }
        },

        _handleWindowKeyUp: function _handleWindowKeyUp(e) {
            if (this.refs.dialogWindow.isOpen()) {
                switch (e.keyCode) {
                    case KeyCode.ENTER:
                        this._handleOKTouchTap();
                        break;
                }
            }
        }

    });

    module.exports = TimePickerDialog;
},{"../dialog-window":16,"../flat-button":23,"../mixins/style-propable":36,"../mixins/window-listenable":38,"../utils/key-code":97,"./clock":78,"react":"react"}],82:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var WindowListenable = require('../mixins/window-listenable');
    var TimePickerDialog = require('./time-picker-dialog');
    var TextField = require('../text-field');

    var emptyTime = new Date();
    emptyTime.setHours(0);
    emptyTime.setMinutes(0);

    var TimePicker = React.createClass({
        displayName: 'TimePicker',

        mixins: [StylePropable, WindowListenable],

        propTypes: {
            defaultTime: React.PropTypes.object,
            format: React.PropTypes.oneOf(['ampm', '24hr']),
            onFocus: React.PropTypes.func,
            onTouchTap: React.PropTypes.func,
            onChange: React.PropTypes.func,
            onShow: React.PropTypes.func,
            onDismiss: React.PropTypes.func },

        windowListeners: {
            'keyup': '_handleWindowKeyUp'
        },

        getDefaultProps: function getDefaultProps() {
            return {
                defaultTime: emptyTime,
                format: 'ampm'
            };
        },

        getInitialState: function getInitialState() {
            return {
                time: this.props.defaultTime,
                dialogTime: new Date()
            };
        },
        formatTime: function formatTime(date) {

            var hours = date.getHours();
            var mins = date.getMinutes();
            var aditional = '';

            if (this.props.format == 'ampm') {
                var isAM = hours < 12;
                hours = hours % 12;
                aditional += isAM ? ' am' : ' pm';
                hours = hours || 12;
            }

            hours = hours.toString();
            mins = mins.toString();

            if (hours.length < 2) hours = '0' + hours;
            if (mins.length < 2) mins = '0' + mins;

            return hours + ':' + mins + aditional;
        },
        render: function render() {
            var _props = this.props;
            var format = _props.format;
            var onFocus = _props.onFocus;
            var onTouchTap = _props.onTouchTap;
            var onShow = _props.onShow;
            var onDismiss = _props.onDismiss;

            var other = _objectWithoutProperties(_props, ['format', 'onFocus', 'onTouchTap', 'onShow', 'onDismiss']);

            var defaultInputValue;

            if (this.props.defaultDate) {
                defaultInputValue = this.formatTime(this.props.defaultTime);
            }

            return React.createElement(
                'div',
                null,
                React.createElement(TextField, _extends({}, other, {
                    ref: 'input',
                    defaultValue: defaultInputValue,
                    onFocus: this._handleInputFocus,
                    onTouchTap: this._handleInputTouchTap })),
                React.createElement(TimePickerDialog, {
                    ref: 'dialogWindow',
                    initialTime: this.state.dialogTime,
                    onAccept: this._handleDialogAccept,
                    onShow: onShow,
                    onDismiss: onDismiss,
                    format: format })
            );
        },

        getTime: function getTime() {
            return this.state.time;
        },

        setTime: function setTime(t) {
            this.setState({
                time: t
            });
            this.refs.input.setValue(this.formatTime(t));
        },

        _handleDialogAccept: function _handleDialogAccept(t) {

            this.setTime(t);
            if (this.props.onChange) this.props.onChange(null, t);
        },

        _handleInputFocus: function _handleInputFocus(e) {
            e.target.blur();
            if (this.props.onFocus) this.props.onFocus(e);
        },

        _handleInputTouchTap: function _handleInputTouchTap(e) {
            this.setState({
                dialogTime: this.getTime()
            });

            this.refs.dialogWindow.show();
            if (this.props.onTouchTap) this.props.onTouchTap(e);
        }

    });

    module.exports = TimePicker;
},{"../mixins/style-propable":36,"../mixins/window-listenable":38,"../text-field":71,"./time-picker-dialog":81,"react":"react"}],83:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var Paper = require('./paper');
    var EnhancedSwitch = require('./enhanced-switch');

    var Toggle = React.createClass({
        displayName: 'Toggle',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            elementStyle: React.PropTypes.object,
            onToggle: React.PropTypes.func,
            toggled: React.PropTypes.bool,
            defaultToggled: React.PropTypes.bool
        },

        getInitialState: function getInitialState() {
            return {
                switched: this.props.toggled || this.props.defaultToggled || this.props.valueLink && this.props.valueLink.value || false };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.toggle;
        },

        getStyles: function getStyles() {
            var toggleSize = 20;
            var toggleTrackWidth = 36;
            var styles = {
                icon: {
                    padding: '4px 0px 6px 2px'
                },
                track: {
                    transition: Transitions.easeOut(),
                    width: toggleTrackWidth,
                    height: 14,
                    borderRadius: 30,
                    backgroundColor: this.getTheme().trackOffColor
                },
                thumb: {
                    transition: Transitions.easeOut(),
                    position: 'absolute',
                    top: 1,
                    left: 2,
                    width: toggleSize,
                    height: toggleSize,
                    lineHeight: '24px',
                    borderRadius: '50%',
                    backgroundColor: this.getTheme().thumbOffColor
                },
                trackWhenSwitched: {
                    backgroundColor: this.getTheme().trackOnColor
                },
                thumbWhenSwitched: {
                    backgroundColor: this.getTheme().thumbOnColor,
                    left: 18
                },
                trackWhenDisabled: {
                    backgroundColor: this.getTheme().trackDisabledColor
                },
                thumbWhenDisabled: {
                    backgroundColor: this.getTheme().thumbDisabledColor
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var onToggle = _props.onToggle;

            var other = _objectWithoutProperties(_props, ['onToggle']);

            var styles = this.getStyles();

            var trackStyles = this.mergeAndPrefix(styles.track, this.state.switched && styles.trackWhenSwitched, this.props.disabled && styles.trackWhenDisabled);

            var thumbStyles = this.mergeAndPrefix(styles.thumb, this.state.switched && styles.thumbWhenSwitched, this.props.disabled && styles.thumbWhenDisabled);

            var toggleElement = React.createElement(
                'div',
                { style: this.mergeAndPrefix(this.props.elementStyle) },
                React.createElement('div', { style: trackStyles }),
                React.createElement(Paper, { style: thumbStyles, circle: true, zDepth: 1 })
            );

            var customRippleStyle = {
                top: '-10',
                left: '-10'
            };

            var rippleColor = this.state.switched ? this.getTheme().thumbOnColor : this.context.muiTheme.component.textColor;

            var enhancedSwitchProps = {
                ref: 'enhancedSwitch',
                inputType: 'checkbox',
                switchElement: toggleElement,
                rippleStyle: customRippleStyle,
                rippleColor: rippleColor,
                iconStyle: styles.icon,
                trackStyle: trackStyles,
                thumbStyle: thumbStyles,
                switched: this.state.switched,
                onSwitch: this._handleToggle,
                onParentShouldUpdate: this._handleStateChange,
                defaultSwitched: this.props.defaultToggled,
                labelPosition: this.props.labelPosition ? this.props.labelPosition : 'left'
            };

            if (this.props.hasOwnProperty('toggled')) enhancedSwitchProps.checked = this.props.toggled;

            return React.createElement(EnhancedSwitch, _extends({}, other, enhancedSwitchProps));
        },

        isToggled: function isToggled() {
            return this.refs.enhancedSwitch.isSwitched();
        },

        setToggled: function setToggled(newToggledValue) {
            this.refs.enhancedSwitch.setSwitched(newToggledValue);
        },

        _handleToggle: function _handleToggle(e, isInputChecked) {
            if (this.props.onToggle) this.props.onToggle(e, isInputChecked);
        },

        _handleStateChange: function _handleStateChange(newSwitched) {
            this.setState({ switched: newSwitched });
        }

    });

    module.exports = Toggle;
},{"./enhanced-switch":21,"./mixins/style-propable":36,"./paper":40,"./styles/transitions":55,"react":"react"}],84:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var Colors = require('../styles/colors');
    var StylePropable = require('../mixins/style-propable');

    var ToolbarGroup = React.createClass({
        displayName: 'ToolbarGroup',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            float: React.PropTypes.string
        },

        getDefaultProps: function getDefaultProps() {
            return {
                float: 'left'
            };
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.toolbar;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing.desktopGutter;
        },

        getStyles: function getStyles() {
            var marginHorizontal = this.getSpacing();
            var marginVertical = (this.getTheme().height - this.context.muiTheme.component.button.height) / 2;
            var styles = {
                root: {
                    position: 'relative',
                    float: this.props.float
                },
                dropDownMenu: {
                    root: {
                        float: 'left',
                        color: Colors.lightBlack, // removes hover color change, we want to keep it
                        display: 'inline-block',
                        marginRight: this.getSpacing()
                    },
                    controlBg: {
                        backgroundColor: this.getTheme().menuHoverColor,
                        borderRadius: 0
                    },
                    underline: {
                        display: 'none'
                    }
                },
                button: {
                    float: 'left',
                    margin: marginVertical + 'px ' + marginHorizontal + 'px',
                    position: 'relative'
                },
                icon: {
                    root: {
                        float: 'left',
                        cursor: 'pointer',
                        color: this.getTheme().iconColor,
                        lineHeight: this.getTheme().height + 'px',
                        paddingLeft: this.getSpacing()
                    },
                    hover: {
                        zIndex: 1,
                        color: Colors.darkBlack
                    }
                },
                span: {
                    float: 'left',
                    color: this.getTheme().iconColor,
                    lineHeight: this.getTheme().height + 'px'
                }
            };
            return styles;
        },

        render: function render() {
            var styles = this.getStyles();

            if (this.props.firstChild) styles.marginLeft = -24;
            if (this.props.lastChild) styles.marginRight = -24;

            var newChildren = React.Children.map(this.props.children, function (currentChild) {
                switch (currentChild.type.displayName) {
                    case 'DropDownMenu':
                        return React.cloneElement(currentChild, {
                            style: styles.dropDownMenu.root,
                            styleControlBg: styles.dropDownMenu.controlBg,
                            styleUnderline: styles.dropDownMenu.underline
                        });
                    case 'DropDownIcon':
                        return React.cloneElement(currentChild, {
                            style: { float: 'left' },
                            iconStyle: styles.icon.root,
                            onMouseOver: this._handleMouseOverDropDownMenu,
                            onMouseOut: this._handleMouseOutDropDownMenu
                        });
                    case 'RaisedButton':case 'FlatButton':
                    return React.cloneElement(currentChild, {
                        style: styles.button
                    });
                    case 'FontIcon':
                        return React.cloneElement(currentChild, {
                            style: styles.icon.root,
                            onMouseOver: this._handleMouseOverFontIcon,
                            onMouseOut: this._handleMouseOutFontIcon
                        });
                    case 'ToolbarSeparator':case 'ToolbarTitle':
                    return React.cloneElement(currentChild, {
                        style: this.mergeStyles(styles.span, currentChild.props.style)
                    });
                    default:
                        return currentChild;
                }
            }, this);

            return React.createElement(
                'div',
                { className: this.props.className, style: this.mergeAndPrefix(styles.root, this.props.style) },
                newChildren
            );
        },

        _handleMouseOverDropDownMenu: function _handleMouseOverDropDownMenu(e) {
            e.target.style.zIndex = this.getStyles().icon.hover.zIndex;
            e.target.style.color = this.getStyles().icon.hover.color;
        },

        _handleMouseOutDropDownMenu: function _handleMouseOutDropDownMenu(e) {
            e.target.style.zIndex = 'auto';
            e.target.style.color = this.getStyles().icon.root.color;
        },

        _handleMouseOverFontIcon: function _handleMouseOverFontIcon(e) {
            e.target.style.zIndex = this.getStyles().icon.hover.zIndex;
            e.target.style.color = this.getStyles().icon.hover.color;
        },

        _handleMouseOutFontIcon: function _handleMouseOutFontIcon(e) {
            e.target.style.zIndex = 'auto';
            e.target.style.color = this.getStyles().icon.root.color;
        } });

    module.exports = ToolbarGroup;
},{"../mixins/style-propable":36,"../styles/colors":50,"react":"react"}],85:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var ToolbarSeparator = React.createClass({
        displayName: 'ToolbarSeparator',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.toolbar;
        },

        getSpacing: function getSpacing() {
            return this.context.muiTheme.spacing;
        },

        render: function render() {

            var styles = this.mergeAndPrefix({
                backgroundColor: this.getTheme().separatorColor,
                display: 'inline-block',
                height: this.getSpacing().desktopGutterMore,
                marginLeft: this.getSpacing().desktopGutter,
                position: 'relative',
                top: (this.getTheme().height - this.getSpacing().desktopGutterMore) / 2,
                width: 1 }, this.props.style);

            return React.createElement('span', { className: this.props.className, style: styles });
        }

    });

    module.exports = ToolbarSeparator;
},{"../mixins/style-propable":36,"react":"react"}],86:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var ToolbarTitle = React.createClass({
        displayName: 'ToolbarTitle',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            text: React.PropTypes.string },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.toolbar;
        },

        render: function render() {
            var _props = this.props;
            var style = _props.style;
            var text = _props.text;

            var other = _objectWithoutProperties(_props, ['style', 'text']);

            var styles = this.mergeAndPrefix({
                paddingRight: this.context.muiTheme.spacing.desktopGutterLess,
                lineHeight: this.getTheme().height + 'px',
                fontSize: this.getTheme().titleFontSize + 'px',
                display: 'inline-block',
                position: 'relative' }, style);

            return React.createElement(
                'span',
                _extends({ style: styles }, other),
                text
            );
        }

    });

    module.exports = ToolbarTitle;
},{"../mixins/style-propable":36,"react":"react"}],87:[function(require,module,exports){
    'use strict';

    var React = require('react');
    var StylePropable = require('../mixins/style-propable');

    var Toolbar = React.createClass({
        displayName: 'Toolbar',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            style: React.PropTypes.object
        },

        getTheme: function getTheme() {
            return this.context.muiTheme.component.toolbar;
        },

        getStyles: function getStyles() {
            return this.mergeAndPrefix({
                boxSizing: 'border-box',
                WebkitTapHighlightColor: 'rgba(0,0,0,0)',
                backgroundColor: this.getTheme().backgroundColor,
                height: this.getTheme().height,
                width: '100%',
                padding: this.props.noGutter ? 0 : '0px ' + this.context.muiTheme.spacing.desktopGutter + 'px'
            }, this.props.style);
        },

        render: function render() {
            return React.createElement(
                'div',
                { className: this.props.className, style: this.getStyles() },
                this.props.children
            );
        }

    });

    module.exports = Toolbar;
},{"../mixins/style-propable":36,"react":"react"}],88:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react');
    var StylePropable = require('./mixins/style-propable');
    var Transitions = require('./styles/transitions');
    var Colors = require('./styles/colors');

    var Tooltip = React.createClass({
        displayName: 'Tooltip',

        mixins: [StylePropable],

        contextTypes: {
            muiTheme: React.PropTypes.object
        },

        propTypes: {
            className: React.PropTypes.string,
            label: React.PropTypes.string.isRequired,
            show: React.PropTypes.bool,
            touch: React.PropTypes.bool
        },

        componentDidMount: function componentDidMount() {
            this._setRippleSize();
        },

        componentDidUpdate: function componentDidUpdate() {
            this._setRippleSize();
        },

        getStyles: function getStyles() {
            var styles = {
                root: {
                    position: 'absolute',
                    fontFamily: this.context.muiTheme.contentFontFamily,
                    fontSize: '10px',
                    lineHeight: '22px',
                    padding: '0 8px',
                    color: Colors.white,
                    overflow: 'hidden',
                    top: -10000,
                    borderRadius: 2,
                    userSelect: 'none',
                    opacity: 0,
                    transition: Transitions.easeOut('0ms', 'top', '450ms') + ',' + Transitions.easeOut('450ms', 'transform', '0ms') + ',' + Transitions.easeOut('450ms', 'opacity', '0ms')
                },
                label: {
                    position: 'relative',
                    whiteSpace: 'nowrap'
                },
                ripple: {
                    position: 'absolute',
                    left: '50%',
                    top: 0,
                    transform: 'translate(-50%, -50%)',
                    borderRadius: '50%',
                    backgroundColor: 'transparent',
                    transition: Transitions.easeOut('0ms', 'width', '450ms') + ',' + Transitions.easeOut('0ms', 'height', '450ms') + ',' + Transitions.easeOut('450ms', 'backgroundColor', '0ms')
                },
                rootWhenShown: {
                    top: -16,
                    opacity: 1,
                    transform: 'translate3d(0px, 16px, 0px)',
                    transition: Transitions.easeOut('0ms', 'top', '0ms') + ',' + Transitions.easeOut('450ms', 'transform', '0ms') + ',' + Transitions.easeOut('450ms', 'opacity', '0ms') },
                rootWhenTouched: {
                    fontSize: '14px',
                    lineHeight: '44px',
                    padding: '0 16px'
                },
                rippleWhenShown: {
                    backgroundColor: Colors.grey600,
                    transition: Transitions.easeOut('450ms', 'width', '0ms') + ',' + Transitions.easeOut('450ms', 'height', '0ms') + ',' + Transitions.easeOut('450ms', 'backgroundColor', '0ms')
                }
            };
            return styles;
        },

        render: function render() {
            var _props = this.props;
            var label = _props.label;

            var other = _objectWithoutProperties(_props, ['label']);

            var styles = this.getStyles();
            return React.createElement(
                'div',
                _extends({}, other, {
                    style: this.mergeAndPrefix(styles.root, this.props.show && styles.rootWhenShown, this.props.touch && styles.rootWhenTouched, this.props.style) }),
                React.createElement('div', {
                    ref: 'ripple',
                    style: this.mergeAndPrefix(styles.ripple, this.props.show && styles.rippleWhenShown) }),
                React.createElement(
                    'span',
                    { style: this.mergeAndPrefix(styles.label) },
                    this.props.label
                )
            );
        },

        _setRippleSize: function _setRippleSize() {
            var ripple = React.findDOMNode(this.refs.ripple);
            var tooltip = window.getComputedStyle(React.findDOMNode(this));
            var tooltipWidth = parseInt(tooltip.getPropertyValue('width'), 10);
            var tooltipHeight = parseInt(tooltip.getPropertyValue('height'), 10);

            var rippleDiameter = Math.sqrt(Math.pow(tooltipHeight, 2) + Math.pow(tooltipWidth / 2, 2)) * 2;

            if (this.props.show) {
                ripple.style.height = rippleDiameter + 'px';
                ripple.style.width = rippleDiameter + 'px';
            } else {
                ripple.style.width = '0px';
                ripple.style.height = '0px';
            }
        }

    });

    module.exports = Tooltip;
},{"./mixins/style-propable":36,"./styles/colors":50,"./styles/transitions":55,"react":"react"}],89:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react/addons');
    var StylePropable = require('../mixins/style-propable');
    var AutoPrefix = require('../styles/auto-prefix');
    var Transitions = require('../styles/transitions');

    var SlideInChild = React.createClass({
        displayName: 'SlideInChild',

        mixins: [StylePropable],

        propTypes: {
            //This callback is needed bacause the direction could change
            //when leaving the dom
            getLeaveDirection: React.PropTypes.func.isRequired
        },

        componentWillEnter: function componentWillEnter(callback) {
            var style = React.findDOMNode(this).style;
            var x = this.props.direction === 'left' ? '100%' : this.props.direction === 'right' ? '-100%' : '0';
            var y = this.props.direction === 'up' ? '100%' : this.props.direction === 'down' ? '-100%' : '0';

            style.opacity = '0';
            AutoPrefix.set(style, 'transform', 'translate3d(' + x + ',' + y + ',0)');

            setTimeout(callback, 0);
        },

        componentDidEnter: function componentDidEnter() {
            var style = React.findDOMNode(this).style;
            style.opacity = '1';
            AutoPrefix.set(style, 'transform', 'translate3d(0,0,0)');
        },

        componentWillLeave: function componentWillLeave(callback) {
            var style = React.findDOMNode(this).style;
            var direction = this.props.getLeaveDirection();
            var x = direction === 'left' ? '-100%' : direction === 'right' ? '100%' : '0';
            var y = direction === 'up' ? '-100%' : direction === 'down' ? '100%' : '0';

            style.opacity = '0';
            AutoPrefix.set(style, 'transform', 'translate3d(' + x + ',' + y + ',0)');

            setTimeout(callback, 450);
        },

        render: function render() {
            var _props = this.props;
            var styles = _props.styles;

            var other = _objectWithoutProperties(_props, ['styles']);

            styles = this.mergeAndPrefix({
                position: 'absolute',
                height: '100%',
                width: '100%',
                top: '0px',
                left: '0px',
                transition: Transitions.easeOut()
            }, this.props.style);

            return React.createElement(
                'div',
                _extends({}, other, {
                    style: styles }),
                this.props.children
            );
        }

    });

    module.exports = SlideInChild;
},{"../mixins/style-propable":36,"../styles/auto-prefix":49,"../styles/transitions":55,"react/addons":"react/addons"}],90:[function(require,module,exports){
    'use strict';

    var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

    function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

    var React = require('react/addons');
    var ReactTransitionGroup = React.addons.TransitionGroup;
    var StylePropable = require('../mixins/style-propable');
    var SlideInChild = require('./slide-in-child');

    var SlideIn = React.createClass({
        displayName: 'SlideIn',

        mixins: [StylePropable],

        propTypes: {
            direction: React.PropTypes.oneOf(['left', 'right', 'up', 'down'])
        },

        getDefaultProps: function getDefaultProps() {
            return {
                direction: 'left'
            };
        },

        render: function render() {
            var _props = this.props;
            var direction = _props.direction;

            var other = _objectWithoutProperties(_props, ['direction']);

            var styles = this.mergeAndPrefix({
                position: 'relative',
                overflow: 'hidden',
                height: '100%'
            }, this.props.style);

            return React.createElement(
                ReactTransitionGroup,
                _extends({}, other, {
                    style: styles,
                    component: 'div' }),
                this._getSlideInChildren()
            );
        },

        _getSlideInChildren: function _getSlideInChildren() {
            return React.Children.map(this.props.children, function (child) {
                return React.createElement(
                    SlideInChild,
                    {
                        key: child.key,
                        direction: this.props.direction,
                        getLeaveDirection: this._getLeaveDirection },
                    child
                );
            }, this);
        },

        _getLeaveDirection: function _getLeaveDirection() {
            return this.props.direction;
        }

    });

    module.exports = SlideIn;
},{"../mixins/style-propable":36,"./slide-in-child":89,"react/addons":"react/addons"}],91:[function(require,module,exports){
    'use strict';

    module.exports = {

        /**
         * The relative brightness of any point in a colorspace, normalized to 0 for
         * darkest black and 1 for lightest white. RGB colors only. Does not take
         * into account alpha values.
         *
         * TODO:
         * - Take into account alpha values.
         * - Identify why there are minor discrepancies for some use cases
         *   (i.e. #F0F & #FFF). Note that these cases rarely occur.
         *
         * Formula: http://www.w3.org/TR/2008/REC-WCAG20-20081211/#relativeluminancedef
         */
        _luminance: function _luminance(color) {
            color = this._decomposeColor(color);

            if (color.type.indexOf('rgb') > -1) {
                var rgb = color.values.map(function (val) {
                    val /= 255; // normalized
                    return val <= 0.03928 ? val / 12.92 : Math.pow((val + 0.055) / 1.055, 2.4);
                });

                return 0.2126 * rgb[0] + 0.7152 * rgb[1] + 0.0722 * rgb[2];
            } else {
                var message = 'Calculating the relative luminance is not available for ' + 'HSL and HSLA.';
                console.error(message);
                return -1;
            }
        },

        /**
         * @params:
         * additionalValue = An extra value that has been calculated but not included
         *                   with the original color object, such as an alpha value.
         */
        _convertColorToString: function _convertColorToString(color, additonalValue) {
            var str = color.type + '(' + parseInt(color.values[0]) + ',' + parseInt(color.values[1]) + ',' + parseInt(color.values[2]);

            if (additonalValue !== undefined) {
                str += ',' + additonalValue + ')';
            } else if (color.values.length == 4) {
                str += ',' + color.values[3] + ')';
            } else {
                str += ')';
            }

            return str;
        },

        // Converts a color from hex format to rgb format.
        _convertHexToRGB: function _convertHexToRGB(color) {
            if (color.length === 4) {
                var extendedColor = '#';
                for (var i = 1; i < color.length; i++) {
                    extendedColor += color.charAt(i) + color.charAt(i);
                }
                color = extendedColor;
            }

            var values = {
                r: parseInt(color.substr(1, 2), 16),
                g: parseInt(color.substr(3, 2), 16),
                b: parseInt(color.substr(5, 2), 16) };

            return 'rgb(' + values.r + ',' + values.g + ',' + values.b + ')';
        },

        // Returns the type and values of a color of any given type.
        _decomposeColor: function _decomposeColor(color) {
            if (color.charAt(0) === '#') {
                return this._decomposeColor(this._convertHexToRGB(color));
            }

            var marker = color.indexOf('(');
            var type = color.substring(0, marker);
            var values = color.substring(marker + 1, color.length - 1).split(',');

            return { type: type, values: values };
        },

        // Set the absolute transparency of a color.
        // Any existing alpha values are overwritten.
        fade: function fade(color, amount) {
            color = this._decomposeColor(color);
            if (color.type == 'rgb' || color.type == 'hsl') color.type += 'a';
            return this._convertColorToString(color, amount);
        },

        // Desaturates rgb and sets opacity to 0.15
        lighten: function lighten(color, amount) {
            color = this._decomposeColor(color);

            if (color.type.indexOf('hsl') > -1) {
                color.values[2] += amount;
                return this._decomposeColor(this._convertColorToString(color));
            } else if (color.type.indexOf('rgb') > -1) {
                for (var i = 0; i < 3; i++) {
                    color.values[i] *= 1 + amount;
                    if (color.values[i] > 255) color.values[i] = 255;
                }
            }

            if (color.type.indexOf('a') <= -1) color.type += 'a';

            return this._convertColorToString(color, '0.15');
        },

        darken: function darken(color, amount) {
            color = this._decomposeColor(color);

            if (color.type.indexOf('hsl') > -1) {
                color.values[2] += amount;
                return this._decomposeColor(this._convertColorToString(color));
            } else if (color.type.indexOf('rgb') > -1) {
                for (var i = 0; i < 3; i++) {
                    color.values[i] *= 1 - amount;
                    if (color.values[i] < 0) color.values[i] = 0;
                }
            }

            return this._convertColorToString(color);
        },

        // Calculates the contrast ratio between two colors.
        //
        // Formula: http://www.w3.org/TR/2008/REC-WCAG20-20081211/#contrast-ratiodef
        contrastRatio: function contrastRatio(background, foreground) {
            var lumA = this._luminance(background);
            var lumB = this._luminance(foreground);

            if (lumA >= lumB) {
                return ((lumA + 0.05) / (lumB + 0.05)).toFixed(2);
            } else {
                return ((lumB + 0.05) / (lumA + 0.05)).toFixed(2);
            }
        },

        /**
         * Determines how readable a color combination is based on its level.
         * Levels are defined from @LeaVerou:
         * https://github.com/LeaVerou/contrast-ratio/blob/gh-pages/contrast-ratio.js
         */
        contrastRatioLevel: function contrastRatioLevel(background, foreground) {
            var levels = {
                'fail': {
                    range: [0, 3],
                    color: 'hsl(0, 100%, 40%)'
                },
                'aa-large': {
                    range: [3, 4.5],
                    color: 'hsl(40, 100%, 45%)'
                },
                'aa': {
                    range: [4.5, 7],
                    color: 'hsl(80, 60%, 45%)'
                },
                'aaa': {
                    range: [7, 22],
                    color: 'hsl(95, 60%, 41%)'
                }
            };

            var ratio = this.contrastRatio(background, foreground);

            for (var level in levels) {
                var range = levels[level].range;
                if (ratio >= range[0] && ratio <= range[1]) return level;
            }
        } };
},{}],92:[function(require,module,exports){
    'use strict';

    var Events = require('./events');

    module.exports = {

        _testSupportedProps: function _testSupportedProps(props) {
            var i,
                el = document.createElement('div');

            for (i in props) {
                if (props.hasOwnProperty(i) && el.style[i] !== undefined) {
                    return props[i];
                }
            }
        },

        //Returns the correct event name to use
        transitionEndEventName: function transitionEndEventName() {
            return this._testSupportedProps({
                'transition': 'transitionend',
                'OTransition': 'otransitionend',
                'MozTransition': 'transitionend',
                'WebkitTransition': 'webkitTransitionEnd'
            });
        },

        animationEndEventName: function animationEndEventName() {
            return this._testSupportedProps({
                'animation': 'animationend',
                '-o-animation': 'oAnimationEnd',
                '-moz-animation': 'animationend',
                '-webkit-animation': 'webkitAnimationEnd'
            });
        },

        onTransitionEnd: function onTransitionEnd(el, callback) {
            var transitionEnd = this.transitionEndEventName();

            Events.once(el, transitionEnd, function () {
                return callback();
            });
        },

        onAnimationEnd: function onAnimationEnd(el, callback) {
            var animationEnd = this.animationEndEventName();

            Events.once(el, animationEnd, function () {
                return callback();
            });
        }

    };
},{"./events":95}],93:[function(require,module,exports){
    'use strict';

    module.exports = {

        addDays: function addDays(d, days) {
            var newDate = this.clone(d);
            newDate.setDate(d.getDate() + days);
            return newDate;
        },

        addMonths: function addMonths(d, months) {
            var newDate = this.clone(d);
            newDate.setMonth(d.getMonth() + months);
            return newDate;
        },

        addYears: function addYears(d, years) {
            var newDate = this.clone(d);
            newDate.setFullYear(d.getFullYear() + years);
            return newDate;
        },

        clone: function clone(d) {
            return new Date(d.getTime());
        },

        cloneAsDate: function cloneAsDate(d) {
            var clonedDate = this.clone(d);
            clonedDate.setHours(0, 0, 0, 0);
            return clonedDate;
        },

        getDaysInMonth: function getDaysInMonth(d) {
            var resultDate = this.getFirstDayOfMonth(d);

            resultDate.setMonth(resultDate.getMonth() + 1);
            resultDate.setDate(resultDate.getDate() - 1);

            return resultDate.getDate();
        },

        getFirstDayOfMonth: function getFirstDayOfMonth(d) {
            return new Date(d.getFullYear(), d.getMonth(), 1);
        },

        getFullMonth: function getFullMonth(d) {
            var month = d.getMonth();
            switch (month) {
                case 0:
                    return 'January';
                case 1:
                    return 'February';
                case 2:
                    return 'March';
                case 3:
                    return 'April';
                case 4:
                    return 'May';
                case 5:
                    return 'June';
                case 6:
                    return 'July';
                case 7:
                    return 'August';
                case 8:
                    return 'September';
                case 9:
                    return 'October';
                case 10:
                    return 'November';
                case 11:
                    return 'December';
            }
        },

        getShortMonth: function getShortMonth(d) {
            var month = d.getMonth();
            switch (month) {
                case 0:
                    return 'Jan';
                case 1:
                    return 'Feb';
                case 2:
                    return 'Mar';
                case 3:
                    return 'Apr';
                case 4:
                    return 'May';
                case 5:
                    return 'Jun';
                case 6:
                    return 'Jul';
                case 7:
                    return 'Aug';
                case 8:
                    return 'Sep';
                case 9:
                    return 'Oct';
                case 10:
                    return 'Nov';
                case 11:
                    return 'Dec';
            }
        },

        getDayOfWeek: function getDayOfWeek(d) {
            var dow = d.getDay();
            switch (dow) {
                case 0:
                    return 'Sunday';
                case 1:
                    return 'Monday';
                case 2:
                    return 'Tuesday';
                case 3:
                    return 'Wednesday';
                case 4:
                    return 'Thursday';
                case 5:
                    return 'Friday';
                case 6:
                    return 'Saturday';
            }
        },

        getWeekArray: function getWeekArray(d) {
            var dayArray = [];
            var daysInMonth = this.getDaysInMonth(d);
            var daysInWeek;
            var emptyDays;
            var firstDayOfWeek;
            var week;
            var weekArray = [];

            for (var i = 1; i <= daysInMonth; i++) {
                dayArray.push(new Date(d.getFullYear(), d.getMonth(), i));
            }

            while (dayArray.length) {
                firstDayOfWeek = dayArray[0].getDay();
                daysInWeek = 7 - firstDayOfWeek;
                emptyDays = 7 - daysInWeek;
                week = dayArray.splice(0, daysInWeek);

                for (var i = 0; i < emptyDays; i++) {
                    week.unshift(null);
                }

                weekArray.push(week);
            }

            return weekArray;
        },

        format: function format(date) {
            var m = date.getMonth() + 1;
            var d = date.getDate();
            var y = date.getFullYear();
            return m + '/' + d + '/' + y;
        },

        isEqualDate: function isEqualDate(d1, d2) {
            return d1 && d2 && d1.getFullYear() === d2.getFullYear() && d1.getMonth() === d2.getMonth() && d1.getDate() === d2.getDate();
        },

        isBeforeDate: function isBeforeDate(d1, d2) {
            var date1 = this.cloneAsDate(d1);
            var date2 = this.cloneAsDate(d2);

            return date1.getTime() < date2.getTime();
        },

        isAfterDate: function isAfterDate(d1, d2) {
            var date1 = this.cloneAsDate(d1);
            var date2 = this.cloneAsDate(d2);

            return date1.getTime() > date2.getTime();
        },

        isBetweenDates: function isBetweenDates(dateToCheck, startDate, endDate) {
            return !this.isBeforeDate(dateToCheck, startDate) && !this.isAfterDate(dateToCheck, endDate);
        },

        monthDiff: function monthDiff(d1, d2) {
            var m;
            m = (d1.getFullYear() - d2.getFullYear()) * 12;
            m += d1.getMonth();
            m -= d2.getMonth();
            return m;
        },

        yearDiff: function yearDiff(d1, d2) {
            return ~ ~(this.monthDiff(d1, d2) / 12);
        }

    };
},{}],94:[function(require,module,exports){
    'use strict';

    module.exports = {

        isDescendant: function isDescendant(parent, child) {
            var node = child.parentNode;

            while (node != null) {
                if (node == parent) return true;
                node = node.parentNode;
            }

            return false;
        },

        offset: function offset(el) {
            var rect = el.getBoundingClientRect();
            return {
                top: rect.top + document.body.scrollTop,
                left: rect.left + document.body.scrollLeft
            };
        },

        addClass: function addClass(el, className) {
            if (el.classList) el.classList.add(className);else el.className += ' ' + className;
        },

        removeClass: function removeClass(el, className) {
            if (el.classList) el.classList.remove(className);else el.className = el.className.replace(new RegExp('(^|\\b)' + className.split(' ').join('|') + '(\\b|$)', 'gi'), ' ');
        },

        hasClass: function hasClass(el, className) {
            if (el.classList) return el.classList.contains(className);else return new RegExp('(^| )' + className + '( |$)', 'gi').test(el.className);
        },

        toggleClass: function toggleClass(el, className) {
            if (this.hasClass(el, className)) this.removeClass(el, className);else this.addClass(el, className);
        },

        forceRedraw: function forceRedraw(el) {
            var originalDisplay = el.style.display;

            el.style.display = 'none';
            el.offsetHeight;
            el.style.display = originalDisplay;
        },

        withoutTransition: function withoutTransition(el, callback) {
            //turn off transition
            el.style.transition = 'none';

            callback();

            //force a redraw
            this.forceRedraw(el);

            //put the transition back
            el.style.transition = '';
        }

    };
},{}],95:[function(require,module,exports){
    'use strict';

    module.exports = {

        once: function once(el, type, callback) {
            var typeArray = type.split(' ');
            var recursiveFunction = function recursiveFunction(e) {
                e.target.removeEventListener(e.type, recursiveFunction);
                return callback(e);
            };

            for (var i = typeArray.length - 1; i >= 0; i--) {
                this.on(el, typeArray[i], recursiveFunction);
            }
        },

        // IE8+ Support
        on: function on(el, type, callback) {
            if (el.addEventListener) {
                el.addEventListener(type, callback);
            } else {
                el.attachEvent('on' + type, function () {
                    callback.call(el);
                });
            }
        },

        // IE8+ Support
        off: function off(el, type, callback) {
            if (el.removeEventListener) {
                el.removeEventListener(type, callback);
            } else {
                el.detachEvent('on' + type, callback);
            }
        }
    };
},{}],96:[function(require,module,exports){
// http://stackoverflow.com/questions/1187518/javascript-array-difference
    'use strict';

    Array.prototype.diff = function (a) {
        return this.filter(function (i) {
            return a.indexOf(i) < 0;
        });
    };

    /**
     *  A recursive merge between two objects.
     *
     *  @param object     - the object whose properties are to be overwritten. It
     *                     should be either the root level or some nested level.
     *  @param overrides - an object containing properties to be overwritten. It
     *                     should have the same structure as the object object.
     */
    var extend = function extend(object, overrides) {
        var mergeObject = {};

        function isValidOverride(value) {
            return value || value === '' || value === null || value === 0;
        }

        Object.keys(object).forEach(function (currentKey) {

            // Arrays and null are also objects,
            var overridesIsValidObject = object[currentKey] && !Array.isArray(object[currentKey]);

            // Recursive call to next level
            if (typeof object[currentKey] === 'object' && overridesIsValidObject) {
                mergeObject[currentKey] = extend(object[currentKey], overrides[currentKey]);
            } else {
                if (overrides && isValidOverride(overrides[currentKey])) {
                    mergeObject[currentKey] = overrides[currentKey];
                } else {
                    mergeObject[currentKey] = object[currentKey];
                }
            }
        });

        // Overrides not defined in object are immediately added.
        if (overrides && typeof overrides === 'object' && !Array.isArray(overrides)) {
            Object.keys(overrides).diff(Object.keys(object)).forEach(function (currentDiff) {
                mergeObject[currentDiff] = overrides[currentDiff];
            });
        }

        return mergeObject;
    };

    module.exports = extend;
},{}],97:[function(require,module,exports){
    "use strict";

    module.exports = {
        DOWN: 40,
        ESC: 27,
        ENTER: 13,
        LEFT: 37,
        RIGHT: 39,
        SPACE: 32,
        TAB: 9,
        UP: 38
    };
},{}],98:[function(require,module,exports){
    "use strict";

    module.exports = {

        Desktop: {
            GUTTER: 24,
            GUTTER_LESS: 16,
            INCREMENT: 64,
            MENU_ITEM_HEIGHT: 32
        },

        getIncrementalDim: function getIncrementalDim(dim) {
            return Math.ceil(dim / this.Desktop.INCREMENT) * this.Desktop.INCREMENT;
        }
    };
},{}],99:[function(require,module,exports){
    /* Modernizr 2.8.3 (Custom Build) | MIT & BSD
     * Build: http://modernizr.com/download/#-borderradius-boxshadow-opacity-csstransforms-csstransforms3d-csstransitions-prefixed-teststyles-testprop-testallprops-prefixes-domprefixes
     */
    'use strict';

    ;

    module.exports = (function (window, document, undefined) {

        var version = '2.8.3',
            Modernizr = {},
            docElement = document.documentElement,
            mod = 'modernizr',
            modElem = document.createElement(mod),
            mStyle = modElem.style,
            inputElem,
            toString = ({}).toString,
            prefixes = ' -webkit- -moz- -o- -ms- '.split(' '),
            omPrefixes = 'Webkit Moz O ms',
            cssomPrefixes = omPrefixes.split(' '),
            domPrefixes = omPrefixes.toLowerCase().split(' '),
            tests = {},
            inputs = {},
            attrs = {},
            classes = [],
            slice = classes.slice,
            featureName,
            injectElementWithStyles = function injectElementWithStyles(rule, callback, nodes, testnames) {

                var style,
                    ret,
                    node,
                    docOverflow,
                    div = document.createElement('div'),
                    body = document.body,
                    fakeBody = body || document.createElement('body');

                if (parseInt(nodes, 10)) {
                    while (nodes--) {
                        node = document.createElement('div');
                        node.id = testnames ? testnames[nodes] : mod + (nodes + 1);
                        div.appendChild(node);
                    }
                }

                style = ['&#173;', '<style id="s', mod, '">', rule, '</style>'].join('');
                div.id = mod;
                (body ? div : fakeBody).innerHTML += style;
                fakeBody.appendChild(div);
                if (!body) {
                    fakeBody.style.background = '';
                    fakeBody.style.overflow = 'hidden';
                    docOverflow = docElement.style.overflow;
                    docElement.style.overflow = 'hidden';
                    docElement.appendChild(fakeBody);
                }

                ret = callback(div, rule);
                if (!body) {
                    fakeBody.parentNode.removeChild(fakeBody);
                    docElement.style.overflow = docOverflow;
                } else {
                    div.parentNode.removeChild(div);
                }

                return !!ret;
            },
            _hasOwnProperty = ({}).hasOwnProperty,
            hasOwnProp;

        if (!is(_hasOwnProperty, 'undefined') && !is(_hasOwnProperty.call, 'undefined')) {
            hasOwnProp = function (object, property) {
                return _hasOwnProperty.call(object, property);
            };
        } else {
            hasOwnProp = function (object, property) {
                return property in object && is(object.constructor.prototype[property], 'undefined');
            };
        }

        if (!Function.prototype.bind) {
            Function.prototype.bind = function bind(that) {

                var target = this;

                if (typeof target != 'function') {
                    throw new TypeError();
                }

                var args = slice.call(arguments, 1),
                    bound = function bound() {

                        if (this instanceof bound) {

                            var F = function F() {};
                            F.prototype = target.prototype;
                            var self = new F();

                            var result = target.apply(self, args.concat(slice.call(arguments)));
                            if (Object(result) === result) {
                                return result;
                            }
                            return self;
                        } else {

                            return target.apply(that, args.concat(slice.call(arguments)));
                        }
                    };

                return bound;
            };
        }

        function setCss(str) {
            mStyle.cssText = str;
        }

        function setCssAll(str1, str2) {
            return setCss(prefixes.join(str1 + ';') + (str2 || ''));
        }

        function is(obj, type) {
            return typeof obj === type;
        }

        function contains(str, substr) {
            return !! ~('' + str).indexOf(substr);
        }

        function testProps(props, prefixed) {
            for (var i in props) {
                var prop = props[i];
                if (!contains(prop, '-') && mStyle[prop] !== undefined) {
                    return prefixed == 'pfx' ? prop : true;
                }
            }
            return false;
        }

        function testDOMProps(props, obj, elem) {
            for (var i in props) {
                var item = obj[props[i]];
                if (item !== undefined) {

                    if (elem === false) return props[i];

                    if (is(item, 'function')) {
                        return item.bind(elem || obj);
                    }

                    return item;
                }
            }
            return false;
        }

        function testPropsAll(prop, prefixed, elem) {

            var ucProp = prop.charAt(0).toUpperCase() + prop.slice(1),
                props = (prop + ' ' + cssomPrefixes.join(ucProp + ' ') + ucProp).split(' ');

            if (is(prefixed, 'string') || is(prefixed, 'undefined')) {
                return testProps(props, prefixed);
            } else {
                props = (prop + ' ' + domPrefixes.join(ucProp + ' ') + ucProp).split(' ');
                return testDOMProps(props, prefixed, elem);
            }
        }

        tests['borderradius'] = function () {
            return testPropsAll('borderRadius');
        };

        tests['boxshadow'] = function () {
            return testPropsAll('boxShadow');
        };

        tests['opacity'] = function () {
            setCssAll('opacity:.55');

            return /^0.55$/.test(mStyle.opacity);
        };
        tests['csstransforms'] = function () {
            return !!testPropsAll('transform');
        };

        tests['csstransforms3d'] = function () {

            var ret = !!testPropsAll('perspective');

            if (ret && 'webkitPerspective' in docElement.style) {

                injectElementWithStyles('@media (transform-3d),(-webkit-transform-3d){#modernizr{left:9px;position:absolute;height:3px;}}', function (node, rule) {
                    ret = node.offsetLeft === 9 && node.offsetHeight === 3;
                });
            }
            return ret;
        };

        tests['csstransitions'] = function () {
            return testPropsAll('transition');
        };

        for (var feature in tests) {
            if (hasOwnProp(tests, feature)) {
                featureName = feature.toLowerCase();
                Modernizr[featureName] = tests[feature]();

                classes.push((Modernizr[featureName] ? '' : 'no-') + featureName);
            }
        }

        Modernizr.addTest = function (feature, test) {
            if (typeof feature == 'object') {
                for (var key in feature) {
                    if (hasOwnProp(feature, key)) {
                        Modernizr.addTest(key, feature[key]);
                    }
                }
            } else {

                feature = feature.toLowerCase();

                if (Modernizr[feature] !== undefined) {
                    return Modernizr;
                }

                test = typeof test == 'function' ? test() : test;

                if (typeof enableClasses !== 'undefined' && enableClasses) {
                    docElement.className += ' ' + (test ? '' : 'no-') + feature;
                }
                Modernizr[feature] = test;
            }

            return Modernizr;
        };

        setCss('');
        modElem = inputElem = null;

        Modernizr._version = version;

        Modernizr._prefixes = prefixes;
        Modernizr._domPrefixes = domPrefixes;
        Modernizr._cssomPrefixes = cssomPrefixes;

        Modernizr.testProp = function (prop) {
            return testProps([prop]);
        };

        Modernizr.testAllProps = testPropsAll;

        Modernizr.testStyles = injectElementWithStyles;
        Modernizr.prefixed = function (prop, obj, elem) {
            if (!obj) {
                return testPropsAll(prop, 'pfx');
            } else {
                return testPropsAll(prop, obj, elem);
            }
        };

        return Modernizr;
    })(window, window.document);
    ;
},{}],100:[function(require,module,exports){
    "use strict";

    var index = 0;

    module.exports = {
        generate: function generate() {
            return "mui-id-" + index++;
        }
    };
},{}],101:[function(require,module,exports){
    /*!
     Copyright (c) 2015 Jed Watson.
     Licensed under the MIT License (MIT), see
     http://jedwatson.github.io/classnames
     */

    function classNames() {
        var classes = '';
        var arg;

        for (var i = 0; i < arguments.length; i++) {
            arg = arguments[i];
            if (!arg) {
                continue;
            }

            if ('string' === typeof arg || 'number' === typeof arg) {
                classes += ' ' + arg;
            } else if (Object.prototype.toString.call(arg) === '[object Array]') {
                classes += ' ' + classNames.apply(null, arg);
            } else if ('object' === typeof arg) {
                for (var key in arg) {
                    if (!arg.hasOwnProperty(key) || !arg[key]) {
                        continue;
                    }
                    classes += ' ' + key;
                }
            }
        }
        return classes.substr(1);
    }

// safely export classNames for node / browserify
    if (typeof module !== 'undefined' && module.exports) {
        module.exports = classNames;
    }

// safely export classNames for RequireJS
    if (typeof define !== 'undefined' && define.amd) {
        define('classnames', [], function() {
            return classNames;
        });
    }

},{}],102:[function(require,module,exports){
    'use strict';

    var React = require('react/addons');
    var emptyFunction = function () {};

// for accessing browser globals
    var root = typeof window !== 'undefined' ? window : this;
    var bodyElement;
    if (typeof document !== 'undefined' && 'body' in document) {
        bodyElement = document.body;
    }

    function updateBoundState (state, bound) {
        if (!bound) return state;
        bound = String(bound);
        var boundTop = !!~bound.indexOf('top');
        var boundRight = !!~bound.indexOf('right');
        var boundBottom = !!~bound.indexOf('bottom');
        var boundLeft = !!~bound.indexOf('left');
        var boundAll = !!~bound.indexOf('all') ||
            !(boundTop || boundRight || boundBottom || boundLeft);
        var boundBox = !~bound.indexOf('point');
        state.boundTop = boundAll || boundTop;
        state.boundRight = boundAll || boundRight;
        state.boundBottom = boundAll || boundBottom;
        state.boundLeft = boundAll || boundLeft;
        state.boundBox = boundBox;
        return state;
    };

    function createUIEvent(draggable) {
        return {
            position: {
                top: draggable.state.offsetTop,
                left: draggable.state.offsetLeft
            }
        };
    }

    function canDragY(draggable) {
        return draggable.props.axis === 'both' ||
            draggable.props.axis === 'y';
    }

    function canDragX(draggable) {
        return draggable.props.axis === 'both' ||
            draggable.props.axis === 'x';
    }

    function isFunction(func) {
        return typeof func === 'function' || Object.prototype.toString.call(func) === '[object Function]'
    }

// @credits https://gist.github.com/rogozhnikoff/a43cfed27c41e4e68cdc
    function findInArray(array, callback) {
        for (var i = 0, length = array.length, element = null; i < length, element = array[i]; i++) {
            if (callback.apply(callback, [element, i, array])) return element;
        }
    }

    function matchesSelector(el, selector) {
        var method = findInArray([
            'matches',
            'webkitMatchesSelector',
            'mozMatchesSelector',
            'msMatchesSelector',
            'oMatchesSelector'
        ], function(method){
            return isFunction(el[method]);
        });

        return el[method].call(el, selector);
    }

// @credits: http://stackoverflow.com/questions/4817029/whats-the-best-way-to-detect-a-touch-screen-device-using-javascript/4819886#4819886
    var isTouchDevice = 'ontouchstart' in root // works on most browsers
        || 'onmsgesturechange' in root; // works on ie10 on ms surface

// look ::handleDragStart
//function isMultiTouch(e) {
//  return e.touches && Array.isArray(e.touches) && e.touches.length > 1
//}

    /**
     * simple abstraction for dragging events names
     * */
    var dragEventFor = (function () {
        var eventsFor = {
            touch: {
                start: 'touchstart',
                move: 'touchmove',
                end: 'touchend'
            },
            mouse: {
                start: 'mousedown',
                move: 'mousemove',
                end: 'mouseup'
            }
        };
        return eventsFor[isTouchDevice ? 'touch' : 'mouse'];
    })();

    /**
     * get {clientX, clientY} positions of control
     * */
    function getControlPosition(e) {
        var position = (e.touches && e.touches[0]) || e;
        return {
            clientX: position.clientX,
            clientY: position.clientY
        }
    }

    function addEvent(el, event, handler) {
        if (!el) { return; }
        if (el.attachEvent) {
            el.attachEvent('on' + event, handler);
        } else if (el.addEventListener) {
            el.addEventListener(event, handler, true);
        } else {
            el['on' + event] = handler;
        }
    }

    function removeEvent(el, event, handler) {
        if (!el) { return; }
        if (el.detachEvent) {
            el.detachEvent('on' + event, handler);
        } else if (el.removeEventListener) {
            el.removeEventListener(event, handler, true);
        } else {
            el['on' + event] = null;
        }
    }

    module.exports = React.createClass({
        displayName: 'Draggable',
        mixins: [React.addons.PureRenderMixin],

        propTypes: {
            /**
             * `axis` determines which axis the draggable can move.
             *
             * 'both' allows movement horizontally and vertically.
             * 'x' limits movement to horizontal axis.
             * 'y' limits movement to vertical axis.
             *
             * Defaults to 'both'.
             */
            axis: React.PropTypes.oneOf(['both', 'x', 'y']),

            /**
             * `handle` specifies a selector to be used as the handle that initiates drag.
             *
             * Example:
             *
             * ```jsx
             *  var App = React.createClass({
     *      render: function () {
     *        return (
     *          <Draggable handle=".handle">
     *            <div>
     *                <div className="handle">Click me to drag</div>
     *                <div>This is some other content</div>
     *            </div>
     *          </Draggable>
     *        );
     *      }
     *  });
             * ```
             */
            handle: React.PropTypes.string,

            /**
             * `cancel` specifies a selector to be used to prevent drag initialization.
             *
             * Example:
             *
             * ```jsx
             *  var App = React.createClass({
     *      render: function () {
     *          return(
     *              <Draggable cancel=".cancel">
     *                  <div>
     *                    <div className="cancel">You can't drag from here</div>
     *            <div>Dragging here works fine</div>
     *                  </div>
     *              </Draggable>
     *          );
     *      }
     *  });
             * ```
             */
            cancel: React.PropTypes.string,

            /**
             * `bound` determines whether to bound the movement to the parent box.
             *
             * The property takes a list of space-separated strings. The Draggable
             * is bounded by the nearest DOMNode.offsetParent. To set the offset
             * parent, give it a position value other than 'static'.
             *
             * Optionally choose one or more bounds from:
             * 'top' bounds movement to the top edge of the parent box.
             * 'right' bounds movement to the right edge of the parent box.
             * 'bottom' bounds movement to the bottom edge of the parent box.
             * 'left' bounds movement to the left edge of the parent box.
             * 'all' bounds movement to all edges (default if not specified).
             *
             * Optionally choose one anchor from:
             * 'point' to constrain only the top-left corner.
             * 'box' to constrain the entire box (default if not specified).
             *
             * You may use more than one bound, e.g. 'top left point'. Set to a
             * falsy value to disable.
             *
             * Defaults to 'all box'.
             */
            bound: React.PropTypes.string,

            /**
             * `grid` specifies the x and y that dragging should snap to.
             *
             * Example:
             *
             * ```jsx
             *   var App = React.createClass({
     *       render: function () {
     *           return (
     *              <Draggable grid={[25, 25]}>
     *                   <div>I snap to a 25 x 25 grid</div>
     *               </Draggable>
     *           );
     *      }
     *   });
             * ```
             */
            grid: React.PropTypes.arrayOf(React.PropTypes.number),

            /**
             * `constrain` takes a function to constrain the dragging.
             *
             * Example:
             *
             * ```jsx
             *   function constrain (snap) {
     *         function constrainOffset (offset, prev) {
     *               var delta = offset - prev;
     *               if (Math.abs(delta) >= snap) {
     *                     return prev + (delta < 0 ? -snap : snap);
     *               }
     *               return prev;
     *         }
     *         return function (pos) {
     *               return {
     *                     top: constrainOffset(pos.top, pos.prevTop),
     *                     left: constrainOffset(pos.left, pos.prevLeft)
     *               };
     *         };
     *   }
             *   var App = React.createClass({
     *       render: function () {
     *           return (
     *               <Draggable constrain={constrain}>
     *                   <div>I snap to a 25 x 25 grid</div>
     *               </Draggable>
     *           );
     *       }
     *   });
             * ```
             */
            constrain: React.PropTypes.func,

            /**
             * `start` specifies the x and y that the dragged item should start at
             *
             * Example:
             *
             * ```jsx
             *  var App = React.createClass({
     *      render: function () {
     *          return (
     *              <Draggable start={{x: 25, y: 25}}>
     *                  <div>I start with left: 25px; top: 25px;</div>
     *              </Draggable>
     *          );
     *      }
     *  });
             * ```
             */
            start: React.PropTypes.object,

            /**
             * `zIndex` specifies the zIndex to use while dragging.
             *
             * Example:
             *
             * ```jsx
             *  var App = React.createClass({
     *      render: function () {
     *          return (
     *              <Draggable zIndex={100}>
     *                  <div>I have a zIndex</div>
     *              </Draggable>
     *          );
     *      }
     *  });
             * ```
             */
            zIndex: React.PropTypes.number,

            /**
             * `useChild` determines whether to use the first child as root.
             *
             * If false, a div is created. This option is required if any children
             * have a ref.
             *
             * Defaults to true.
             */
            useChild: React.PropTypes.bool,

            /**
             * Called when dragging starts.
             *
             * Example:
             *
             * ```js
             *  function (event, ui) {}
             * ```
             *
             * `event` is the Event that was triggered.
             * `ui` is an object:
             *
             * ```js
             *  {
     *    position: {top: 0, left: 0}
     *  }
             * ```
             */
            onStart: React.PropTypes.func,

            /**
             * Called while dragging.
             *
             * Example:
             *
             * ```js
             *  function (event, ui) {}
             * ```
             *
             * `event` is the Event that was triggered.
             * `ui` is an object:
             *
             * ```js
             *  {
     *    position: {top: 0, left: 0}
     *  }
             * ```
             */
            onDrag: React.PropTypes.func,

            /**
             * Called when dragging stops.
             *
             * Example:
             *
             * ```js
             *  function (event, ui) {}
             * ```
             *
             * `event` is the Event that was triggered.
             * `ui` is an object:
             *
             * ```js
             *  {
     *    position: {top: 0, left: 0}
     *  }
             * ```
             */
            onStop: React.PropTypes.func,

            /**
             * A workaround option which can be passed if onMouseDown needs to be accessed, since it'll always be blocked (due to that there's internal use of onMouseDown)
             *
             */
            onMouseDown: React.PropTypes.func
        },

        getDefaultProps: function () {
            return {
                axis: 'both',
                bound: null,
                handle: null,
                cancel: null,
                grid: null,
                start: {},
                zIndex: NaN,
                useChild: true,
                onStart: emptyFunction,
                onDrag: emptyFunction,
                onStop: emptyFunction,
                onMouseDown: emptyFunction
            };
        },

        getInitialState: function () {
            var state = {
                // Whether or not currently dragging
                dragging: false,

                // Pointer offset on screen
                clientX: 0, clientY: 0,

                // DOMNode offset relative to parent
                offsetLeft: this.props.start.x || 0, offsetTop: this.props.start.y || 0
            };

            updateBoundState(state, this.props.bound);

            return state;
        },

        componentWillReceiveProps: function (nextProps) {
            var state = updateBoundState({}, nextProps.bound);
            if (nextProps.start) {
                if (nextProps.start.x != null) {
                    state.offsetLeft = nextProps.start.x || 0;
                }
                if (nextProps.start.y != null) {
                    state.offsetTop = nextProps.start.y || 0;
                }
            }
            this.setState(state);
        },

        componentWillUnmount: function() {
            // Remove any leftover event handlers
            removeEvent(root, dragEventFor['move'], this.handleDrag);
            removeEvent(root, dragEventFor['end'], this.handleDragEnd);
        },

        handleDragStart: function (e) {
            // todo: write right implementation to prevent multitouch drag
            // prevent multi-touch events
            // if (isMultiTouch(e)) {
            //     this.handleDragEnd.apply(e, arguments);
            //     return
            // }

            // Make it possible to attach event handlers on top of this one
            this.props.onMouseDown(e);

            // Short circuit if handle or cancel prop was provided and selector doesn't match
            if ((this.props.handle && !matchesSelector(e.target, this.props.handle)) ||
                (this.props.cancel && matchesSelector(e.target, this.props.cancel))) {
                return;
            }

            var dragPoint = getControlPosition(e);

            // Initiate dragging
            this.setState({
                dragging: true,
                clientX: dragPoint.clientX,
                clientY: dragPoint.clientY
            });

            // Call event handler
            this.props.onStart(e, createUIEvent(this));

            // Add event handlers
            addEvent(root, dragEventFor['move'], this.handleDrag);
            addEvent(root, dragEventFor['end'], this.handleDragEnd);

            // Add dragging class to body element
            if (bodyElement) bodyElement.className += ' react-draggable-dragging';
        },

        handleDragEnd: function (e) {
            // Short circuit if not currently dragging
            if (!this.state.dragging) {
                return;
            }

            // Turn off dragging
            this.setState({
                dragging: false
            });

            // Call event handler
            this.props.onStop(e, createUIEvent(this));

            // Remove event handlers
            removeEvent(root, dragEventFor['move'], this.handleDrag);
            removeEvent(root, dragEventFor['end'], this.handleDragEnd);

            // Remove dragging class from body element
            if (bodyElement) {
                var className = bodyElement.className;
                bodyElement.className =
                    className.replace(/(?:^|\s+)react-draggable-dragging\b/, ' ');
            }
        },

        handleDrag: function (e) {
            var dragPoint = getControlPosition(e);
            var offsetLeft = this._toPixels(this.state.offsetLeft);
            var offsetTop = this._toPixels(this.state.offsetTop);

            var state = {
                offsetLeft: offsetLeft,
                offsetTop: offsetTop
            };

            // Get parent DOM node
            var node = this.getDOMNode();
            var offsetParent = node.offsetParent;
            var offset, boundingValue;

            if (canDragX(this)) {
                // Calculate updated position
                offset = offsetLeft + dragPoint.clientX - this.state.clientX;

                // Bound movement to parent box
                if (this.state.boundLeft) {
                    boundingValue = state.offsetLeft - node.offsetLeft;
                    if (offset < boundingValue) {
                        offset = boundingValue;
                    }
                }
                if (this.state.boundRight) {
                    boundingValue += offsetParent.clientWidth;
                    if (this.state.boundBox) {
                        boundingValue -= node.offsetWidth;
                    }
                    if (offset > boundingValue) {
                        offset = boundingValue;
                    }
                }
                // Update left
                state.offsetLeft = offset;
            }

            if (canDragY(this)) {
                // Calculate updated position
                offset = offsetTop + dragPoint.clientY - this.state.clientY;
                // Bound movement to parent box
                if (this.state.boundTop) {
                    boundingValue = state.offsetTop - node.offsetTop;
                    if (offset < boundingValue) {
                        offset = boundingValue;
                    }
                }
                if (this.state.boundBottom) {
                    boundingValue += offsetParent.clientHeight;
                    if (this.state.boundBox) {
                        boundingValue -= node.offsetHeight;
                    }
                    if (offset > boundingValue) {
                        offset = boundingValue;
                    }
                }
                // Update top
                state.offsetTop = offset;
            }

            var constrain = this.props.constrain;
            var grid = this.props.grid;

            // Backwards-compatibility for snap to grid
            if (!constrain && Array.isArray(grid)) {
                var constrainOffset = function (offset, prev, snap) {
                    var delta = offset - prev;
                    if (Math.abs(delta) >= snap) {
                        return prev + parseInt(delta / snap, 10) * snap;
                    }
                    return prev;
                };
                constrain = function (pos) {
                    return {
                        left: constrainOffset(pos.left, pos.prevLeft, grid[0]),
                        top: constrainOffset(pos.top, pos.prevTop, grid[1])
                    };
                };
            }

            // Constrain if function has been provided
            var positions;
            if (constrain) {
                // Constrain positions
                positions = constrain({
                    prevLeft: this.state.offsetLeft,
                    prevTop: this.state.offsetTop,
                    left: state.offsetLeft,
                    top: state.offsetTop
                });
                if (positions) {
                    // Update left
                    if ('left' in positions && !isNaN(positions.left)) {
                        state.offsetLeft = positions.left;
                    }
                    // Update top
                    if ('top' in positions && !isNaN(positions.top)) {
                        state.offsetTop = positions.top;
                    }
                }
            }

            // Save new state
            state.clientX = this.state.clientX + (state.offsetLeft - offsetLeft);
            state.clientY = this.state.clientY + (state.offsetTop - offsetTop);
            this.setState(state);

            // Call event handler
            this.props.onDrag(e, createUIEvent(this));
        },

        onTouchStart: function (e) {
            e.preventDefault(); // prevent for scroll
            return this.handleDragStart.apply(this, arguments);
        },

        render: function () {
            var style = {
                top: this.state.offsetTop,
                left: this.state.offsetLeft
            };

            // Set zIndex if currently dragging and prop has been provided
            if (this.state.dragging && !isNaN(this.props.zIndex)) {
                style.zIndex = this.props.zIndex;
            }

            var props = {
                style: style,
                className: 'react-draggable',

                onMouseDown: this.handleDragStart,
                onTouchStart: this.onTouchStart,

                onMouseUp: this.handleDragEnd,
                onTouchEnd: this.handleDragEnd
            };

            // Reuse the child provided
            // This makes it flexible to use whatever element is wanted (div, ul, etc)
            if (this.props.useChild) {
                return React.addons.cloneWithProps(React.Children.only(this.props.children), props);
            }

            return React.DOM.div(props, this.props.children);
        },

        _toPixels: function (value) {

            // Support percentages
            if (typeof value == 'string' && value.slice(-1) == '%') {
                return parseInt((+value.replace('%', '') / 100) *
                    this.getDOMNode().offsetParent.clientWidth, 10) || 0;
            }

            // Invalid values become zero
            var i = parseInt(value, 10);
            if (isNaN(i) || !isFinite(i)) return 0;

            return i;
        }

    });

},{"react/addons":"react/addons"}],103:[function(require,module,exports){
// shim for using process in browser

    var process = module.exports = {};
    var queue = [];
    var draining = false;
    var currentQueue;
    var queueIndex = -1;

    function cleanUpNextTick() {
        draining = false;
        if (currentQueue.length) {
            queue = currentQueue.concat(queue);
        } else {
            queueIndex = -1;
        }
        if (queue.length) {
            drainQueue();
        }
    }

    function drainQueue() {
        if (draining) {
            return;
        }
        var timeout = setTimeout(cleanUpNextTick);
        draining = true;

        var len = queue.length;
        while(len) {
            currentQueue = queue;
            queue = [];
            while (++queueIndex < len) {
                currentQueue[queueIndex].run();
            }
            queueIndex = -1;
            len = queue.length;
        }
        currentQueue = null;
        draining = false;
        clearTimeout(timeout);
    }

    process.nextTick = function (fun) {
        var args = new Array(arguments.length - 1);
        if (arguments.length > 1) {
            for (var i = 1; i < arguments.length; i++) {
                args[i - 1] = arguments[i];
            }
        }
        queue.push(new Item(fun, args));
        if (queue.length === 1 && !draining) {
            setTimeout(drainQueue, 0);
        }
    };

// v8 likes predictible objects
    function Item(fun, array) {
        this.fun = fun;
        this.array = array;
    }
    Item.prototype.run = function () {
        this.fun.apply(null, this.array);
    };
    process.title = 'browser';
    process.browser = true;
    process.env = {};
    process.argv = [];
    process.version = ''; // empty string to avoid regexp issues
    process.versions = {};

    function noop() {}

    process.on = noop;
    process.addListener = noop;
    process.once = noop;
    process.off = noop;
    process.removeListener = noop;
    process.removeAllListeners = noop;
    process.emit = noop;

    process.binding = function (name) {
        throw new Error('process.binding is not supported');
    };

// TODO(shtylman)
    process.cwd = function () { return '/' };
    process.chdir = function (dir) {
        throw new Error('process.chdir is not supported');
    };
    process.umask = function() { return 0; };

},{}],"material-ui":[function(require,module,exports){
    'use strict';

    module.exports = {
        AppBar: require('./app-bar'),
        AppCanvas: require('./app-canvas'),
        BeforeAfterWrapper: require('./before-after-wrapper'),
        Checkbox: require('./checkbox'),
        CircularProgress: require('./circular-progress'),
        ClearFix: require('./clearfix'),
        DatePicker: require('./date-picker/date-picker'),
        Dialog: require('./dialog'),
        DialogWindow: require('./dialog-window'),
        DropDownIcon: require('./drop-down-icon'),
        DropDownMenu: require('./drop-down-menu'),
        EnhancedButton: require('./enhanced-button'),
        FlatButton: require('./flat-button'),
        FloatingActionButton: require('./floating-action-button'),
        FontIcon: require('./font-icon'),
        IconButton: require('./icon-button'),
        LeftNav: require('./left-nav'),
        LinearProgress: require('./linear-progress'),
        Menu: require('./menu/menu'),
        MenuItem: require('./menu/menu-item'),
        Mixins: {
            Classable: require('./mixins/classable'),
            ClickAwayable: require('./mixins/click-awayable'),
            WindowListenable: require('./mixins/window-listenable'),
            StylePropable: require('./mixins/style-propable'),
            StyleResizable: require('./mixins/style-resizable')
        },
        Paper: require('./paper'),
        RadioButton: require('./radio-button'),
        RadioButtonGroup: require('./radio-button-group'),
        RaisedButton: require('./raised-button'),
        Slider: require('./slider'),
        SvgIcon: require('./svg-icon'),
        Icons: {
            NavigationMenu: require('./svg-icons/navigation-menu'),
            NavigationChevronLeft: require('./svg-icons/navigation-chevron-left'),
            NavigationChevronRight: require('./svg-icons/navigation-chevron-right')
        },
        Styles: {
            AutoPrefix: require('./styles/auto-prefix'),
            Colors: require('./styles/colors'),
            Spacing: require('./styles/spacing'),
            ThemeManager: require('./styles/theme-manager'),
            Transitions: require('./styles/transitions'),
            Typography: require('./styles/typography')
        },
        Snackbar: require('./snackbar'),
        Tab: require('./tabs/tab'),
        Tabs: require('./tabs/tabs'),
        Theme: require('./theme'),
        Toggle: require('./toggle'),
        TimePicker: require('./time-picker'),
        TextField: require('./text-field'),
        Toolbar: require('./toolbar/toolbar'),
        ToolbarGroup: require('./toolbar/toolbar-group'),
        ToolbarSeparator: require('./toolbar/toolbar-separator'),
        ToolbarTitle: require('./toolbar/toolbar-title'),
        Tooltip: require('./tooltip'),
        Utils: {
            CssEvent: require('./utils/css-event'),
            Dom: require('./utils/dom'),
            Events: require('./utils/events'),
            KeyCode: require('./utils/key-code'),
            KeyLine: require('./utils/key-line'),
            ColorManipulator: require('./utils/color-manipulator'),
            Extend: require('./utils/extend'),
            UniqueId: require('./utils/unique-id')
        }
    };
},{"./app-bar":1,"./app-canvas":2,"./before-after-wrapper":3,"./checkbox":4,"./circular-progress":5,"./clearfix":6,"./date-picker/date-picker":13,"./dialog":17,"./dialog-window":16,"./drop-down-icon":18,"./drop-down-menu":19,"./enhanced-button":20,"./flat-button":23,"./floating-action-button":24,"./font-icon":25,"./icon-button":26,"./left-nav":28,"./linear-progress":29,"./menu/menu":32,"./menu/menu-item":31,"./mixins/classable":34,"./mixins/click-awayable":35,"./mixins/style-propable":36,"./mixins/style-resizable":37,"./mixins/window-listenable":38,"./paper":40,"./radio-button":42,"./radio-button-group":41,"./raised-button":43,"./slider":47,"./snackbar":48,"./styles/auto-prefix":49,"./styles/colors":50,"./styles/spacing":51,"./styles/theme-manager":52,"./styles/transitions":55,"./styles/typography":56,"./svg-icon":57,"./svg-icons/navigation-chevron-left":60,"./svg-icons/navigation-chevron-right":62,"./svg-icons/navigation-menu":63,"./tabs/tab":68,"./tabs/tabs":70,"./text-field":71,"./theme":72,"./time-picker":79,"./toggle":83,"./toolbar/toolbar":87,"./toolbar/toolbar-group":84,"./toolbar/toolbar-separator":85,"./toolbar/toolbar-title":86,"./tooltip":88,"./utils/color-manipulator":91,"./utils/css-event":92,"./utils/dom":94,"./utils/events":95,"./utils/extend":96,"./utils/key-code":97,"./utils/key-line":98,"./utils/unique-id":100}]},{},[]);